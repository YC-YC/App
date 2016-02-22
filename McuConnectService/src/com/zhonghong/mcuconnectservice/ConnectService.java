package com.zhonghong.mcuconnectservice;

import com.zhonghong.jni.JniClient;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

public class ConnectService extends Service {

	private static final int MSG_UPDATE = 100;
	private static final String TAG = "ConnectService";
	
	private Context mContext;
	private MyHandle mHandler;
	
	private int registerNum = 0;	//remote rigister num
	final RemoteCallbackList<ITaskCallback> mRemoteCallbackList = new RemoteCallbackList<ITaskCallback>();

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
		LOG("onRebind");
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		LOG("onCreate");
		mContext = this;
		mHandler = new MyHandle();
		init();
	}


	private void init() {
		/*if (T.mColdHelper == null)
		{
			new ColdHelper(mContext);
		}
		T.mColdHelper.setColdListChangedCallBack(new ColdListChangedCallBack() 
		{
			@Override
			public void callback() 
			{
				mHandler.sendEmptyMessageDelayed(MSG_UPDATE, 0);
			}
		});*/
	}

	// bindService will do
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		LOG("onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		LOG("onDestroy");
		super.onDestroy();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		LOG("onUnbind");
		return super.onUnbind(intent);
	}
	
	private final ITaskBinder.Stub mBinder = new ITaskBinder.Stub(){

		//register remote Callback
		@Override
		public void registerCallback(ITaskCallback callback)
				throws RemoteException {
			if (callback != null)
			{
				registerNum++;
				mRemoteCallbackList.register(callback);
			}
			LOG("registerCallback num = " + registerNum);
		}
		
		//unregister remote Callback
		@Override
		public void unregisterCallback(ITaskCallback callback)
				throws RemoteException {
			if (callback != null)
			{
				mRemoteCallbackList.unregister(callback);
				registerNum--;
			}
			LOG("unregisterCallback num = " + registerNum);
		}

		@Override
		public int getStatus() throws RemoteException {
			return JniClient.getStatus();
		}

		@Override
		public void postCmd(int cmd) throws RemoteException {
			LOG("postCmd = " + cmd);
			JniClient.postCmd(cmd);
		}
		
	};
	
	//callback all register
		private void serviceCallback()
		{
			int num = mRemoteCallbackList.beginBroadcast();
			LOG("callback client num = " + num);
			for (int i = 0; i < num; i++)
			{
				try {
					mRemoteCallbackList.getBroadcastItem(i).MCUCallback();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			mRemoteCallbackList.finishBroadcast();
		}
	
	class MyHandle extends Handler
	{
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == MSG_UPDATE)
			{
				serviceCallback();
			}
		}
		
	}
	
	
	private void LOG(String string)
	{
		Log.i(TAG, string);
	}
	
	static{
		System.loadLibrary("Connection");
	}
}
