package com.example.ycwideget;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;

import com.example.ycwideget.FreshCtrl.Fresh;

public class FMWidgetInfo implements BaseImp, Fresh {

	private Context mContext;
	private FreshCtrl mFreshCtrl;
	private static int STANDARD = 1000;	
	private static int FASTEST = 20;
	private static int FASTESTCONTINUE = 1000;
	
	private static final String APP_URL_ALL = "http://127.0.0.1:8989/dvr?req = all& item=null";
	private static final String POST_APP_URL = "http://127.0.0.1:8989/dvr";

	private static final String TAG = "FMWidgetInfo";
	
	public FMWidgetInfo(Context context) {
		mContext = context;
		mFreshCtrl = new FreshCtrl(this, STANDARD, FASTEST, FASTESTCONTINUE);
		RequestManager.getInstance(context).registerBaseImp(T.APP.FM, this);
	}
	
	@Override
	public boolean doFresh() {
		boolean isChange = false;
		if (getAppInfo())
		{
			isChange = true;
		}
		
		/*if (getBtMusicInfo())
		{
			isChange = true;
		}*/
		
		return isChange;
	}

	@Override
	public boolean requestInfo() {
		return mFreshCtrl.fresh();
	}

	@Override
	public boolean sendRequest(int cmd) {
		switch (cmd) {
		case T.FMCmd.OPEN_CLOSE_FM:
			OpenCloseFM(!T.FM.isOpen);
			break;
		case T.FMCmd.OPEN_FM_PAGE:
			LOG("OpenSettings");
			Intent it = new Intent(Settings.ACTION_LOCALE_SETTINGS);
			it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mContext.startActivity(it);
			break;
		}
		return false;
	}

	private boolean getAppInfo() {
		boolean isChange = false;
		String result = HttpUtil.getRequest(APP_URL_ALL);
		if (result == null)
		{
			return false;
		}
		
		JSONTokener tokener = new JSONTokener(result);
		try {
			JSONObject msgs = (JSONObject) tokener.nextValue();
			msgs = msgs.getJSONObject("result");
			/*int state = msgs.getInt("btcurstate");
			if (state != T.BtMusic.connectstate)
			{
				isChange = true;
				T.BtMusic.connectstate = state;
			}
			
			String song = msgs.getString("playfile");
			if ( song != null && !song.equals(T.BtMusic.song))
			{
				isChange = true;
				T.BtMusic.song = song;
			}
			
			if (state > 2)
			{
				isChange = true;
				T.BtMusic.isUpdatePinpu = true;
			}
			else
			{
				T.BtMusic.isUpdatePinpu = false;
			}*/
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return isChange;
	}
	
	private boolean OpenCloseFM(boolean isOpen) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("req", "fmswitch");
		map.put("key", isOpen ? "on":"off");
		HttpUtil.postRequest(POST_APP_URL, map);
		return true;
	}
	
	private void openZuiApp(Context mContext2, String soName, String data) {
		Intent intent = new Intent("widget_entrance");
		intent.setComponent(new ComponentName("com.example.zuiserver", "com.example.zuiserver.StartActivity"));
		intent.putExtra("et1", data);
		intent.putExtra("et2", soName);
		intent.putExtra("et3", "widget");
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
		mContext2.startActivity(intent);
	}
	
	void LOG(String string)
	{
		Log.e(TAG, string);
	}
	
}
