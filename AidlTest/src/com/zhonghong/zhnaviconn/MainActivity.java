package com.zhonghong.zhnaviconn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.zhonghong.camera.CameraSurfaceView;
import com.zhonghong.conn.ConnZui.InitListener;
import com.zhonghong.conn.ZHRequest;
import com.zhonghong.jarmain.ZHCar;
import com.zhonghong.log.L;

/**
 * 测试代码
 * @author zhonghong.chenli
 * date:2015-9-6下午8:36:10	<br/>
 */
public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private Button bt_setfreq;
	private Button bt_fmonoff;
	private Button bt_setvideo;
	private Button bt_colsevideo;
	private Button bt_takephoto;
	private Button bt_record;
	private Button bt_closetft;
	private Button bt_getMedia;
	private Button bt_getBt;
	private TextView tv_content;
	private boolean fm_on = false;
	private int limitespeed = 0;
	private int edogmode = 0;
	HashMap<String, String> data = new HashMap<String, String>();
	JSONObject jsonRoot = new JSONObject();
	JSONObject jsonSub = new JSONObject();
	
	CameraSurfaceView mCameraSurfaceView;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//初始化
		ZHCar.getInstance().init(this, mInitListener);	
		UiInit();
	}
	
	private void UiInit() {
		tv_content = (TextView) findViewById(R.id.tv_content);
		bt_setfreq = (Button) findViewById(R.id.bt_setfreq);
		bt_fmonoff = (Button) findViewById(R.id.bt_fmonoff);
		bt_setvideo = (Button) findViewById(R.id.bt_setvideo);
		bt_colsevideo = (Button) findViewById(R.id.bt_colsevideo);
		bt_takephoto = (Button) findViewById(R.id.bt_takephoto);
		bt_record = (Button) findViewById(R.id.bt_record);
		bt_closetft = (Button) findViewById(R.id.bt_closetft);
		bt_getMedia = (Button) findViewById(R.id.bt_getmedia);
		bt_getBt = (Button) findViewById(R.id.bt_getbt);
		bt_setfreq.setOnClickListener(listener);
		bt_fmonoff.setOnClickListener(listener);
		bt_setvideo.setOnClickListener(listener);
		bt_colsevideo.setOnClickListener(listener);
		bt_takephoto.setOnClickListener(listener);
		bt_record.setOnClickListener(listener);
		bt_closetft.setOnClickListener(listener);
		bt_getMedia.setOnClickListener(listener);
		bt_getBt.setOnClickListener(listener);
		mCameraSurfaceView = (CameraSurfaceView) findViewById(R.id.cameraShow);
	}

	OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO 自动生成的方法存根
			switch (v.getId()) {
			case R.id.bt_setfreq:
				setFmFeq(10400);
				break;
			case R.id.bt_fmonoff:
				fm_on = !fm_on;
				fmSenderPowerSwitch(fm_on);
				break;
			case R.id.bt_setvideo:
				SetVidio(476, 20, 200, 150, 0);			//设置位置大小
				mCameraSurfaceView.openCamera(); 		//打开camera 重新
				break;
			case R.id.bt_colsevideo:
				mCameraSurfaceView.closeCamera();
				break;
			case R.id.bt_takephoto:
//				mCameraSurfaceView.closeCamera();		//关闭camera
//				takephoto();
//				 L.i(TAG, "获取DVR信息：" + reqDvrInfo());
				L.i(TAG, "获取DVR信息：" + getFmFreq());
				break; 
			case R.id.bt_getmedia:
				L.i(TAG, "获取媒体信息：" + getMediaInfo());
				break;
			case R.id.bt_getbt:
				L.i(TAG, "获取蓝牙信息：" + getBtInfo());
				break;	
			case R.id.bt_record:
//				Record();
				BtCtrl("reqspeechreleasemic");
				break;
			case R.id.bt_closetft:
				CloseTft();
//				BtCtrl("notifyspeechgetmic");
				break;
			default:
				break;
			}
		}
	};
	
	//TODO doClick
	public void doClick(View view)
	{
		switch (view.getId()) {
		case R.id.bt_getdvr:
			L.i(TAG, "获取DVR信息：" + reqDvrInfo());
			tv_content.setText(reqDvrInfo());
			break;
		case R.id.bt_setlimitespeed:
			limitespeed = (limitespeed+1)%10;
			setLimiteSpeed(limitespeed);
			break;
		case R.id.bt_setedogmode:
			edogmode = (edogmode+1)%3;
			L.i(TAG, "获setEDogMode：" + setEDogMode(edogmode));
			break;
		case R.id.bt_playshoot:
//			playClickSound();
				Intent it = new Intent(Intent.ACTION_MAIN);
				ComponentName name = new ComponentName("com.android.systemui", "com.android.systemui.recent.RecentsActivity");
				it.setComponent(name);
				startActivity(it);
			break;
		case R.id.bt_getrunningtask:
			ArrayList<String> listTask = getRunningTask();
			String reslut = "";
			tv_content.setText("");
			for (int i = 0; i < listTask.size(); i++)
			{
				reslut = listTask.get(i);
				Log.i(TAG, reslut);
				tv_content.append(reslut);
			}
			
			break;
		case R.id.bt_openandplaymusic:
			playRandomMusic();
			break;
		case R.id.bt_openandplayvideo:
			playRandomVedio();
			break;
		case R.id.bt_voicestream:
			adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
			break;
		}
	}
	
	/*
	 * 调音量
	 * 
	 */
	private void adjustStreamVolume(int streamType, int direction, int flags)
	{
		AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		am.adjustStreamVolume(streamType, direction, flags);
	}
	
	  private void playRandomMusic() {
		  openZuiApp(MainActivity.this,"libAppAudio.so", "ZH_PUBLIC_APPAUDIO_10", "audio_speech_play::");
//	        ZuiApp.openZuiAppToPage(MainActivity.this,
//	                ZuiApp.PACKAGENAME, ZuiApp.CN_AUDIO, "audio_speech_play::");
	    }
	  private void playRandomVedio() {
		  openZuiApp(MainActivity.this,"libAppVideo.so", "ZH_PUBLIC_APPVIDEO_10", "audio_speech_play::");
//	        ZuiApp.openZuiAppToPage(MainActivity.this,
//	                ZuiApp.PACKAGENAME, ZuiApp.CN_AUDIO, "audio_speech_play::");
	    }
	
	  private void openZuiApp(Context mContext2, String soName, String data,String cmd) {
			Intent intent = new Intent("widget_entrance");
			intent.setComponent(new ComponentName("com.example.zuiserver", "com.example.zuiserver.StartActivity"));
			intent.putExtra("et1", data);
			intent.putExtra("et2", soName);
			intent.putExtra("et3", cmd);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
			mContext2.startActivity(intent);
		}
	  
	private ArrayList<String> getRunningTask() {
		ActivityManager am = (ActivityManager) MainActivity.this.getSystemService(ACTIVITY_SERVICE);
		List<RunningTaskInfo> tasks = am.getRunningTasks(5);
		Log.i(TAG, "getTasks size = " + tasks.size());
		ArrayList<String> listTask = new ArrayList<String>();
		int i = 1;
		for (RunningTaskInfo task: tasks)
		{
			listTask.add("" + i + "." + task.topActivity.getPackageName() + ", "  +
		task.topActivity.getClassName() + ";" + 
		task.id + ";" + 
		task.baseActivity.getPackageName() + task.baseActivity.getClassName() + "\r\n");
			i++;
		}
		
		return listTask;
		
	}

	private void playClickSound() {
		MediaPlayer shootMP = null;
		AudioManager audioManager = (AudioManager) MainActivity.this.getSystemService(Context.AUDIO_SERVICE);
		int volume = audioManager.getStreamVolume(AudioManager.STREAM_NOTIFICATION);
		if (volume != 0)
		{
			if (shootMP == null)
			{
				shootMP = MediaPlayer.create(MainActivity.this, Uri.parse("file:///system/media/audio/ui/camera_click.ogg"));
			}
			if (shootMP != null)
			{
				shootMP.start();
				Log.i("ScreentShoot", "Play OK");
			}
		}
		else
		{
			Log.i("ScreentShoot", "STREAM_NOTIFICATION = 0");
		}
	}

	/**
	 * 初始化状态监听
	 */
	InitListener mInitListener = new InitListener() {
		@Override
		public void state(int state, String content) {
			switch(state){
			case InitListener.STATE_SUCCESS:
				//测试发送， 必须在初始化成功后才能发送，其实就是简单的一个aidl连接状态
				 L.i(TAG, "获取FM信息：" + getFmFreq());
				 L.i(TAG, "获取DVR信息：" + reqDvrInfo());
				 L.i(TAG, "获取MCU信息：" + GetMCUVersion());
				break;
			case InitListener.STATE_FAIL:
				break;
			case InitListener.STATE_RECONN:
				break;
			} 
		}
	}; 
	
	/*
	 * 设置限速
	 */
	private String setLimiteSpeed(int speed)
	{
		L.i(TAG, "setLimiteSpeed = " + speed);
		data.clear();
		data.put("req", "limitespeed");
		data.put("val", "" + speed);
		return ZHRequest.getInstance().httpPostFormAidl("/dvr", data);	
	}
	private String setEDogMode(int mode)
	{
		L.i(TAG, "setEDogMode = " + mode);
		data.clear();
		data.put("req", "edogmode");
		data.put("val", "" + mode);
		return ZHRequest.getInstance().httpPostFormAidl("/dvr", data);	
	}
	
	/**
	 * fm发射开关
	 */
	private String fmSenderPowerSwitch(boolean isOn){
		L.i(TAG, "fm发射控制：" + isOn);
//		data.put("req", "fmswitch");
		data.clear();
		data.put("req", "adasvoiceopen");
		data.put("val", isOn ? "on" : "off");
		return ZHRequest.getInstance().httpPostFormAidl("/dvr", data);
	}
	 
	/**
	 * 设置fm频率
	 */
	private String setFmFeq(int freq){
		data.clear(); 
		data.put("req", "setfmfreq");
		data.put("val", "" + freq);
		return ZHRequest.getInstance().httpPostFormAidl("/dvr", data);
	}
	
	/*
	 * 测试视频
	 */
	private String SetVidio(int x, int y, int width, int height, int offset)
	{
		data.clear();
		data.put("req", "setpreview");
		data.put("val", "widget");
		data.put("x", "" + x);
		data.put("y", "" + y);
		data.put("w", "" + width);
		data.put("h", "" + height);
		data.put("offset", "" + offset);
		L.i(TAG, "视频测试：" + data.toString());
		
		return ZHRequest.getInstance().httpPostFormAidl("/dvr", data);
	}
	
	
	/**
	 * 获取fm频点
	 * 返回json格式如下
		{
			"class":	"fm",
			"status":	"ok",
			"req":	"all",
			"item":	"null",
			"result":	
			{
			"fm_open":	true,
			"fm_freq":	8750
			}
		}
		
	 */
	private String getFmFreq(){
//		data.put("val", "fm");
		data.clear();
		data.put("req", "info");
		data.put("val", "adas");
		return ZHRequest.getInstance().httpPostFormAidl("/dvr", data);
	}
	
	private String getMediaInfo(){
//		data.put("val", "fm");
		data.clear();
		data.put("req", "all");
		data.put("val", "true");
		return ZHRequest.getInstance().httpPostFormAidl("/audio", data);
	}
	private String getBtInfo(){
//		data.put("val", "fm");
		data.clear();
		data.put("req", "all");
		data.put("val", "true");
		return ZHRequest.getInstance().httpPostFormAidl("/bt", data);
	}
	/**
	 * 取dvr相关信息，返回的json中包含录制状态等
	 * @return
	 */
	private String reqDvrInfo(){
//		data.put("req", "info");
//		data.put("val", "fm");
//		data.put("req", "setkey");
//		data.put("val", "photograph");
//		data.put("val", "switchrecord");
//		data.put("req", "fmswitch");
//		data.put("val", "off");
		data.clear();
		data.put("req", "all");
		data.put("val", "true");
		return ZHRequest.getInstance().httpPostFormAidl("/dvr", data);
	}
	
	
	/**
	 * 录像
	 * dvr控制测试
	 */
	public String Record(){
		return dvrCtrl("switchrecord");
	}
	/**
	 * 关屏
	 * 
	 */
	public String CloseTft(){
		data.clear();
		data.put("req", "settftoff");
		data.put("val", "true");
		return ZHRequest.getInstance().httpPostFormAidl("/system", data);
	}
	/**
	 * 获取MCU版本信息
	 * 
	 */
	public String GetMCUVersion(){
		data.clear();
		data.put("req", "version");
		return ZHRequest.getInstance().httpPostFormAidl("/setup", data);
	}
	/**
	 * 拍照
	 * dvr控制测试
	 */
	public String takephoto(){
		return dvrCtrl("photograph");
	}
	
	/**
	 * dvr控制
	 * @param cmd
	 * @return
	 */
	private String dvrCtrl(String cmd){
		data.clear();
		data.put("req", "setkey");
		data.put("val", cmd);
		return ZHRequest.getInstance().httpPostFormAidl("/dvr", data);
	}
	/**
	 * dvr控制
	 * @param cmd
	 * @return
	 */
	private String BtCtrl(String cmd){
		data.clear();
		data.put("req", "setkey");
		data.put("val", cmd);
		return ZHRequest.getInstance().httpPostFormAidl("/bt", data);
	}
}
