package com.example.ycwideget;

public class T {

	public static class Thread{
		public static boolean bluetoothmusic = false;
		public static boolean fm = false;
	};
	
	/*
	 * action
	 */
	public static class Action{
		//更新蓝牙音乐一起
		public static final String UPDATE_BTAUDIO = "com.example.ycwidget.UPDATE_BTAUDIO";	
		//更新蓝牙
		public static final String UPDATE_BTAUDIO_BT = "com.example.ycwidget.UPDATE_BTAUDIO_BT";	
		//更新音乐
		public static final String UPDATE_BTAUDIO_AUDIO = "com.example.ycwidget.UPDATE_BTAUDIO_AUDIO";
		//更新FM
		public static final String UPDATE_FM = "com.example.ycwidget.UPDATE_FM";
			
	};
	
	/*
	 * BTAudio
	 */
	public static class BTAudio{
		public static boolean isAudioPage = true;
	};
	
	/*
	 * BTAudioCmd
	 */
	public static class BTAudioCmd{
		public static final int TO_AUDIO = 1;
		public static final int TO_BT = 2;
		public static final int OPEN_AUDIO = 3;
		public static final int OPEN_BT = 4;
		public static final int AUDIO_PLAY = 5;
		public static final int BT_PLAYPAUSE = 6;
		public static final int AUDIO_PAUSE = 7;
	};
	
	/*
	 *FM按键Key 
	 */
	public static class FMCmd{
		public static final int OPEN_CLOSE_FM = 1;
		public static final int OPEN_FM_PAGE = 2;
	};
	
	/*
	 * 应用
	 */
	public static class APP{
		public static final int BLUETOOTH_AUDIO = 1;
		public static final int FM = 2;
	};
	
	/*
	 * 蓝牙应用信息
	 */
	public static class BtMusic{
		public static boolean isUpdatePinpu = false;
		public static int pinpuid = 0;
		public static int state = 0;
		public static int connectstate = 0;
		public static String song = "";
		public static String artist = "";
		public static String playstate = "";
	}
	
	/*
	 * 音乐应用信息
	 */
	public static class Audio{
		public static boolean isUpdatePinpu = false;
		public static int pinpuid = 0;
		public static int state = 0;
		public static String song = "";
		public static String artist = "";
		public static String playstate = "";
	}
	
	/*
	 * FM信息
	 */
	public static class FM{
		public static boolean isOpen = false;
		public static int freq = 10000;
		public static final int MIN_FREQ = 8750;
		public static final int MAX_FREQ = 10800;
	}
	
}
