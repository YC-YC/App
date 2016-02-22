package com.example.ycwideget;

import java.io.File;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;

@SuppressLint("SdCardPath")
public class FMWidget extends AppWidgetProvider {

	private static final String TAG = "FMWidget";
	private static Set<Integer> idSets = new HashSet<Integer>();	//存储所有组件
	
	private Bitmap bitmapDrawable;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO 自动生成的方法存根
		super.onReceive(context, intent);
		String action = intent.getAction();
		LOG("Receive " + action);
		if (T.Action.UPDATE_FM.equals(action) )
		{
			updateAppAppWidget(context);
		}
		//按键广播
		else if (intent.hasCategory(Intent.CATEGORY_ALTERNATIVE))
		{
			Uri data = intent.getData();
			int key = Integer.parseInt(data.getSchemeSpecificPart());
			switch (key) {
			case T.FMCmd.OPEN_CLOSE_FM:
				RequestManager.getInstance(context).sendRequest(T.APP.FM, T.FMCmd.OPEN_CLOSE_FM);
				break;
			case T.FMCmd.OPEN_FM_PAGE:
				RequestManager.getInstance(context).sendRequest(T.APP.FM, T.FMCmd.OPEN_FM_PAGE);
				break;
			}
		}
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		for (int appWidgetId : appWidgetIds) {
			idSets.add(Integer.valueOf(appWidgetId));
		}
		updateAppAppWidget(context);
	}

	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		super.onDeleted(context, appWidgetIds);
		for(int appWidget:appWidgetIds)
		{
			idSets.remove(appWidget);
		}
		if (idSets.size() <= 0)
		{
			T.Thread.fm = false;
		}
	}

	@Override
	public void onEnabled(Context context) {
		super.onEnabled(context);
		T.Thread.fm = true;
		Intent it = new Intent(context, LaodServer.class);
		context.startService(it);
	}

	@Override
	public void onDisabled(Context context) {
		super.onDisabled(context);
	}
	
	private void updateAppAppWidget(Context context) {
		Iterator<Integer> iterator = idSets.iterator();
		int appWidgetId;
		RemoteViews remoteView;
		while(iterator.hasNext())
		{
			appWidgetId = iterator.next();
			remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_fm);
			
			//更新数据
			if (T.FM.isOpen)
			{
				remoteView.setImageViewResource(R.id.fm_togglebutton, R.drawable.fm_open_selector);
			}
			else
			{
				remoteView.setImageViewResource(R.id.fm_togglebutton, R.drawable.fm_close_selector);
			}
			//画频率
			String freq = new DecimalFormat(".0").format((float)T.FM.freq/100);
			remoteView.setImageViewBitmap(R.id.fm_freq, getTextBitmat(context, freq, 50));
			//画线
			float xOffset = (218/(float)(T.FM.MAX_FREQ-T.FM.MIN_FREQ))*(T.FM.freq - T.FM.MIN_FREQ);
			LOG("xOffset=" + xOffset);
			remoteView.setImageViewBitmap(R.id.fm_line, getFreqLineBitmat(context, xOffset, 0));
			//设置监听事件
			remoteView.setOnClickPendingIntent(R.id.fm_togglebutton, 
					getBtPendingIntent(context, T.FMCmd.OPEN_CLOSE_FM));
			remoteView.setOnClickPendingIntent(R.id.img_fm_slider, 
					getBtPendingIntent(context, T.FMCmd.OPEN_FM_PAGE));
			
			AppWidgetManager.getInstance(context).updateAppWidget(appWidgetId, remoteView);
		}
	}

	private Bitmap getFreqLineBitmat(Context context, float xOffset, float yOffset) {
		
		if (bitmapDrawable == null)
		{
			bitmapDrawable = ((BitmapDrawable) context.getResources()
					.getDrawable(R.drawable.fm_freq_cur))
					.getBitmap();
		}
		
		Bitmap bitmap = Bitmap.createBitmap(218, 98, Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		if (canvas != null)
		{
			
			Rect rect = new Rect();
			rect.left = (int)xOffset;
			rect.top = (int)yOffset;
//			rect.right = rect.left+bitmapDrawable.getWidth();
//			rect.bottom = rect.top + bitmapDrawable.getHeight();
			/*
			 * 不同的设备，获取的值是不一样的
			 */
			rect.right = rect.left+ 2;
			rect.bottom = rect.top +  98;
			canvas.drawBitmap(bitmapDrawable, null, rect, null);

		}
		LOG("Bitmap getWidth=" + bitmapDrawable.getWidth() 
				+ " Bitmap Height=" + bitmapDrawable.getHeight() 
				+ " densityDpi=" + bitmapDrawable.getDensity());
//		canvas.drawBitmap(bitmapDrawable, xOffset, yOffset, null);
		
		return bitmap;
	}

	private Bitmap getTextBitmat(Context context, String text, int textSize) {
		Bitmap bitmap = Bitmap.createBitmap(218, 40, Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		
		Paint paint = new Paint();
		File file = new File("/mnt/sdcard/Roboto-Light.ttf");
		if (!file.exists())
		{
			LOG("file no exists");
			return null;
		}
		paint.setAntiAlias(true);
		paint.setAlpha(255);
		paint.setSubpixelText(true);
		Typeface typeface = Typeface.createFromFile(file);
		paint.setTypeface(typeface );
		paint.setTextSize(textSize);
		paint.setTextAlign(Align.CENTER);
		paint.setColor(context.getResources().getColor(R.color.fmnumcolor));
		
		//x值为显示中心位置
		//y为底部位置
		canvas.drawText(text, 218/2, 40, paint);
		LOG("drawTest");
		return bitmap;
	}


	private PendingIntent getBtPendingIntent(Context context, int key) {
		Intent intent = new Intent();
		intent.setClass(context, FMWidget.class);
		intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
		intent.setData(Uri.parse("custom:" + key));
		PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
		return pi;
	}
	
	void LOG(String string)
	{
		Log.e(TAG, string);
	}

}
