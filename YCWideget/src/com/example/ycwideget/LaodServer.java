package com.example.ycwideget;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class LaodServer extends Service {

	Context mContext;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this.getApplicationContext();
		startListener();
	}

	private void startListener() {
		new Thread(){
			public void run() {
				while (true) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
					if (!isAtHome()){
						continue;
					}
					
					if (T.Thread.bluetoothmusic 
							&& RequestManager.getInstance(mContext).requestInfo(T.APP.BLUETOOTH_AUDIO))
					{
						Intent updateIntent;
						if (T.BTAudio.isAudioPage)
						{
							updateIntent = new Intent(T.Action.UPDATE_BTAUDIO_AUDIO);
						}
						else
						{
							updateIntent = new Intent(T.Action.UPDATE_BTAUDIO_BT);
						}
						mContext.sendBroadcast(updateIntent);
					}
					
					if (T.Thread.fm 
							&& RequestManager.getInstance(mContext).requestInfo(T.APP.FM))
					{
						Intent updateIntent;
						updateIntent = new Intent(T.Action.UPDATE_FM);
						mContext.sendBroadcast(updateIntent);
					}
				}
			}

		}.start();
	}
	private boolean isAtHome() {
		return false;
	};
	
	

}
