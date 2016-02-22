package com.example.ycwideget;

import java.util.HashMap;

import android.content.Context;

public class RequestManager {

	private HashMap<Integer, BaseImp> requesInfotMap = new HashMap<Integer, BaseImp>();
	private HashMap<Integer, BaseImp> sendrequestMap = new HashMap<Integer, BaseImp>();
	
	private static RequestManager mRequestManager = null;
	
	private RequestManager(){}
	
	private void init(Context context)
	{
		new BlueToothMusicInfo(context);
		new FMWidgetInfo(context);
	}
	
	public static RequestManager getInstance(Context context)
	{
		if (mRequestManager == null)
		{
			mRequestManager = new RequestManager();
			mRequestManager.init(context);
		}
		return mRequestManager;
	}
	
	/*
	 * ע����Ϣ
	 */
	public void registerBaseImp(int app, BaseImp imp)
	{
		requesInfotMap.put(app, imp);
		sendrequestMap.put(app, imp);
	}
	
	/*
	 * ��ȡ��Ϣ
	 */
	public boolean requestInfo(int app)
	{
		return requesInfotMap.get(app).requestInfo();
	}
	
	/*
	 * ������Ϣ
	 */
	public void sendRequest(final int app, final int cmd)
	{
		new Thread(){
			public void run() {
				sendrequestMap.get(app).sendRequest(cmd);
			};
		}.start();
	}
}
