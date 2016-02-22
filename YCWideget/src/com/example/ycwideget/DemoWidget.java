package com.example.ycwideget;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class DemoWidget extends AppWidgetProvider {

	private static Set<Integer> idSets = new HashSet<Integer>();	//存储所有组件
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO 自动生成的方法存根
		super.onReceive(context, intent);
		String action = intent.getAction();
	/*	if (T.Action.UPDATE_BTAUDIO.equals(action) 
				|| T.Action.UPDATE_BTAUDIO_BT.equals(action)
				|| T.Action.UPDATE_BTAUDIO_AUDIO.equals(action))
		{
			updateAppAppWidget(context);
		}
		//按键广播
		else */if (intent.hasCategory(Intent.CATEGORY_ALTERNATIVE))
		{
			Uri data = intent.getData();
			int key = Integer.parseInt(data.getSchemeSpecificPart());
			switch (key) {
			/*case T.BTAudioCmd.TO_AUDIO:
				T.BTAudio.isAudioPage = true;
				updateAppAppWidget(context);
				break;
			case T.BTAudioCmd.TO_BT:
				T.BTAudio.isAudioPage = false;
				updateAppAppWidget(context);
				break;*/
			default:
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
			
			//设置监听事件
			
			AppWidgetManager.getInstance(context).updateAppWidget(appWidgetId, remoteView);
		}
	}

	private PendingIntent getBtPendingIntent(Context context, int key) {
		Intent intent = new Intent();
		intent.setClass(context, BluetoothMusicWidget.class);
		intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
		intent.setData(Uri.parse("custom:" + key));
		PendingIntent pi = PendingIntent.getBroadcast(context, 0, intent, 0);
		return pi;
	}
	

}
