package com.example.testremoteservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.zhonghong.mcuconnectservice.ITaskBinder;

public class MainActivity extends Activity {

	private ITaskBinder mAidlTaskBinder;
	
	private Context mContext;
	
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO 自动生成的方法存根
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mAidlTaskBinder = ITaskBinder.Stub.asInterface(service);
			try {
				mAidlTaskBinder.registerCallback(null);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.activity_main);
	}
	
	public void doClick(View view)
	{
		switch (view.getId()) {
		case R.id.button1:
			bindService();
			break;
		case R.id.button2:
			unBindRemoteService();
			break;
		case R.id.button3:
			getStatus();
			break;
		case R.id.button4:
			postCmd();
			break;
		default:
			break;
		}
	}
	
	private void bindService() {
		Intent it = new Intent("com.zhonghong.mcuconnectservice.ConnectService");
//		context.startService(it);
		mContext.bindService(it, conn, Context.BIND_AUTO_CREATE);
	}
	
	private void unBindRemoteService()
	{
		if (conn != null)
		{
			mContext.unbindService(conn);
		}
	}
	
	private void getStatus() {
		if (conn != null)
		{
			try {
				LOG("" + mAidlTaskBinder.getStatus());
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	private void postCmd() {
		if (conn != null)
		{
			try {
				mAidlTaskBinder.postCmd(100);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	private void LOG(String string)
	{
		Log.i("TestRemoteService", string);
	}
}
