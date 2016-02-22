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
import android.view.View;
import android.widget.RemoteViews;


public class BluetoothMusicWidget extends AppWidgetProvider {

	private static Set<Integer> idSets = new HashSet<Integer>();	//存储所有组件
	private int[] audiopinpus = {R.drawable.au_fre_1,
								R.drawable.au_fre_2,
								R.drawable.au_fre_3,
								R.drawable.au_fre_4,
								R.drawable.au_fre_5};
	private int[] btpinpus = {R.drawable.bt_fre_1,
			R.drawable.bt_fre_2,
			R.drawable.bt_fre_3,
			R.drawable.bt_fre_4};
	
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		String action = intent.getAction();
		if (T.Action.UPDATE_BTAUDIO.equals(action) 
				|| T.Action.UPDATE_BTAUDIO_BT.equals(action)
				|| T.Action.UPDATE_BTAUDIO_AUDIO.equals(action))
		{
			updateAppAppWidget(context);
		}
		//按键广播
		else if (intent.hasCategory(Intent.CATEGORY_ALTERNATIVE))
		{
			Uri data = intent.getData();
			int key = Integer.parseInt(data.getSchemeSpecificPart());
			switch (key) {
			case T.BTAudioCmd.TO_AUDIO:
				T.BTAudio.isAudioPage = true;
				updateAppAppWidget(context);
				break;
			case T.BTAudioCmd.TO_BT:
				T.BTAudio.isAudioPage = false;
				updateAppAppWidget(context);
				break;
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
			T.Thread.bluetoothmusic = false;
		}
	}

	@Override
	public void onEnabled(Context context) {
		super.onEnabled(context);
		T.Thread.bluetoothmusic = true;
		Intent it = new Intent(context, LaodServer.class);
		context.startService(it);
		
	}

	@Override
	public void onDisabled(Context context) {
		// TODO 自动生成的方法存根
		super.onDisabled(context);
	}
	
private void updateAppAppWidget(Context context) {
		Iterator<Integer> iterator = idSets.iterator();
		int appWidgetId;
		RemoteViews remoteView;
		while(iterator.hasNext())
		{
			appWidgetId = iterator.next();
			remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_bluebooth);
			
			/*
			 * 显示界面
			 */
			if (T.BTAudio.isAudioPage)
			{
				remoteView.setInt(R.id.audio_widget, "setVisibility", View.VISIBLE);
				remoteView.setInt(R.id.bt_widget, "setVisibility", View.INVISIBLE);
			}
			else
			{
				remoteView.setInt(R.id.audio_widget, "setVisibility", View.INVISIBLE);
				remoteView.setInt(R.id.bt_widget, "setVisibility", View.VISIBLE);
			}
			
			//音乐
			if (T.BTAudio.isAudioPage)
			{
				if (T.Audio.isUpdatePinpu)
				{
				}
				else
				{
					remoteView.setTextViewText(R.id.app_audio_name, "本地音乐");
					String songName = T.Audio.song;
					if (songName == null || songName.equals(""))
					{
						remoteView.setTextViewText(R.id.app_audio_name, "暂无本地音乐");
					}
					else
					{
						remoteView.setTextViewText(R.id.app_audio_name, songName);
					}
				}
				
				if (!"play".equals(T.Audio.playstate))
				{
					remoteView.setImageViewResource(R.id.audio_play_pause, R.drawable.play_selector);
					remoteView.setImageViewResource(R.id.audio_pinpu, R.drawable.music_pingpu);
					T.Audio.isUpdatePinpu = false;
					remoteView.setOnClickPendingIntent(R.id.audio_bottom_layout, 
							getBtPendingIntent(context, T.BTAudioCmd.AUDIO_PLAY));
				}
				else
				{
					remoteView.setImageViewResource(R.id.audio_play_pause, R.drawable.pause_selector);
					remoteView.setImageViewResource(R.id.audio_pinpu, audiopinpus[T.Audio.pinpuid]);
					T.Audio.pinpuid = (++T.Audio.pinpuid)%5;
					remoteView.setOnClickPendingIntent(R.id.audio_bottom_layout, 
							getBtPendingIntent(context, T.BTAudioCmd.AUDIO_PAUSE));
				}
				
				remoteView.setOnClickPendingIntent(R.id.audio_top_layout, 
						getBtPendingIntent(context, T.BTAudioCmd.OPEN_AUDIO));
				
				remoteView.setOnClickPendingIntent(R.id.to_btmusic, 
						getBtPendingIntent(context, T.BTAudioCmd.TO_BT));
			}
			//蓝牙音乐
			else
			{
				
				if (T.BtMusic.isUpdatePinpu)
				{
				}
				else
				{
					remoteView.setTextViewText(R.id.app_bt_name, "蓝牙音乐");
					String songName = T.BtMusic.song;
					if (songName == null || songName.equals(""))
					{
						remoteView.setTextViewText(R.id.bt_song_name, "暂无蓝牙音乐");
					}
					else
					{
						remoteView.setTextViewText(R.id.bt_song_name, songName);
					}
				}
				
				if (!"play".equals(T.BtMusic.playstate))
				{
					
					remoteView.setImageViewResource(R.id.bt_pinpu, R.drawable.bt_pingpu);
					T.BtMusic.isUpdatePinpu = false;
				}
				else
				{
					remoteView.setImageViewResource(R.id.bt_pinpu, btpinpus[T.BtMusic.pinpuid]);
					T.BtMusic.pinpuid = (++T.BtMusic.pinpuid)%4;
				}
				
				remoteView.setImageViewResource(R.id.bt_play_pause, R.drawable.playpause_selector);
				
				remoteView.setOnClickPendingIntent(R.id.bt_bottom_layout, 
						getBtPendingIntent(context, T.BTAudioCmd.BT_PLAYPAUSE));
				
				remoteView.setOnClickPendingIntent(R.id.bt_top_layout, 
						getBtPendingIntent(context, T.BTAudioCmd.OPEN_AUDIO));
				
				remoteView.setOnClickPendingIntent(R.id.to_audio, 
						getBtPendingIntent(context, T.BTAudioCmd.TO_AUDIO));
			}
			
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
