package com.zhonghong.jni;


import android.util.Log;

/*
 * Jni交互函数
 */
public class JniClient {
	
	private static final String TAG = "JniClient";
	
	static public native void HelloBlueTooth();	//测试函数
	static public native String GetBlueToothVersion();	//
	
	static public native int getStatus();
	static public native void postCmd(int cmd);
	
	public static String CCallJavaForString(int cmd, String val)
	{
		Log.i(TAG, "CCallJavaForString cmd=" + cmd + ", val=" + val);
		return "Java CCallJavaForString";
	}
	
	private void LOG(String str)
	{
		Log.i(TAG, str);
	}
}
