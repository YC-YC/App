package com.zhonghong.radio.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YC
 * @time 2016-2-23 下午6:01:59
 */
public class T {

	public static final int FM_1 = 0;
	public static final int FM_2 = 1;
	public static final int FM_3 = 2;
	public static final int AM_1 = 3;
	public static final int AM_2 = 4;
	
	public static final int STEP_MODE_TIME = 3*1000;	//步进时间3S
	public static final int STEP_MODE_DIFF = 3*100;		//步进时间300ms
	
	public static final int SCAN_MODE_TIME = 5*1000;	//步进时间5S
	public static final int SCAN_MODE_DIFF = 5*100;		//步进时间500ms
	
	
	public static final int LIST_COUNT = 3;		//列表个数
	
	public static final String RADIO_INFO_FILE = "radioinfo";		//收音机信息
	
	public static final String RADIO_INFO_KEY_BAND = "band";	
	
	public static final String RADIO_INFO_KEY_FM_CURFREQ = "CurFMFreq";	
	public static final String RADIO_INFO_KEY_FM_FREQ_LIST_SIZE = "CurFMFreqListSize";
	public static final String RADIO_INFO_KEY_FM_FREQ_LIST = "CurFMFreqList";	
	public static final String RADIO_INFO_KEY_FM_SELITEM = "CurFMSelItem";	

	public static final String RADIO_INFO_KEY_AM_CURFREQ = "CurAMFreq";	
	public static final String RADIO_INFO_KEY_AM_FREQ_LIST_SIZE = "CurAMFreqListSize";
	public static final String RADIO_INFO_KEY_AM_FREQ_LIST = "CurAMFreqList";	
	public static final String RADIO_INFO_KEY_AM_SELITEM = "CurAMSelItem";
	
	
	public static boolean mStepMode = false;	//步进模式
	public static long mLastLongClickTime = 0;	//左右键的最后长按时间
	
	public static boolean mScanMode = false;	//浏览模式
	public static int mScanItem = 0;		//浏览项
	public static boolean mScanItemSel = false;	//浏览项被选中
	public static long mStartScanItemTime = 0;	//开始浏览某一项的时间
	
	
	//收音机的值
	public static class RadioValue{
		public static int mBand = FM_1;
		
		public static boolean mMute = false;
		
		public static boolean mLoc = true;
		public static boolean mST = true;
		public static boolean mOO = true;
		
		//FM Value
		public static int mMinFMFreq = 8750;
		public static int mMaxFMFreq = 10800;
		public static int mCurFMFreq = 10000;
		public static int mFMStep = 5;
		public static int mFMSelItem = -1;
		public static List<Integer> mFMFreqList = new ArrayList<Integer>();
		
		//AM Value
		public static int mMinAMFreq = 522;
		public static int mMaxAMFreq = 1620;
		public static int mCurAMFreq = 819;
		public static int mAMStep = 9;
		public static int mAMSelItem = -1;
		public static List<Integer> mAMFreqList = new ArrayList<Integer>();
	}
	
	//BIT位1为有效
		public static final int KEYBOARD_EFFECTIVE_189 = 0x302; //11,0000,0010,189高亮
		public static final int KEYBOARD_EFFECTIVE_16789 = 0x3A2; //11,1100,0010
		public static final int KEYBOARD_EFFECTIVE_0_8 = 0x1FF; //01,1111,1111
		public static final int KEYBOARD_EFFECTIVE_0_7 = 0x0FF; //00,1111,1111
		public static final int KEYBOARD_EFFECTIVE_0_6 = 0x07F; //00,0111,1111
		public static final int KEYBOARD_EFFECTIVE_0_4 = 0x01F; //00,0001,1111
		public static final int KEYBOARD_EFFECTIVE_05 = 0x021; //00,0010,0001
		public static final int KEYBOARD_EFFECTIVE_7_9 = 0x380; //11,1000,0000
		public static final int KEYBOARD_EFFECTIVE_6_9 = 0x3C0; //11,1100,0000
		public static final int KEYBOARD_EFFECTIVE_5_9 = 0x3E0; //11,1110,0000
		public static final int KEYBOARD_EFFECTIVE_0 = 0x001; //00,0000,0001
		public static final int KEYBOARD_EFFECTIVE_1 = 0x002; //00,0000,0010
		public static final int KEYBOARD_EFFECTIVE_2 = 0x004; //00,0000,0100
		public static final int KEYBOARD_EFFECTIVE_3 = 0x008; //00,0000,1000
		public static final int KEYBOARD_EFFECTIVE_4 = 0x010; //00,0001,0000
		public static final int KEYBOARD_EFFECTIVE_5 = 0x020; //00,0010,0000
		public static final int KEYBOARD_EFFECTIVE_6 = 0x040; //00,0100,0000
		public static final int KEYBOARD_EFFECTIVE_7 = 0x080; //00,1000,0000
		public static final int KEYBOARD_EFFECTIVE_8 = 0x100; //01,0000,0000
		public static final int KEYBOARD_EFFECTIVE_9 = 0x200; //10,0000,0000
		public static final int KEYBOARD_EFFECTIVE_09 = 0x201; //10,0000,0001
		public static final int KEYBOARD_EFFECTIVE_01 = 0x003; //00,0000,0011
		public static final int KEYBOARD_EFFECTIVE_0_2 = 0x007; //00,0000,0111
		public static final int KEYBOARD_EFFECTIVE_2_9 = 0x3FC; //11,1111,1100
		public static final int KEYBOARD_EFFECTIVE_3_9 = 0x3F8; //11,1111,1000
		public static final int KEYBOARD_EFFECTIVE_15_9 = 0x3E2; //11,1110,0010
		public static final int KEYBOARD_EFFECTIVE_369 = 0x248; //10,0100,1000
		public static final int KEYBOARD_EFFECTIVE_0369 = 0x249; //10,0100,1001
		public static final int KEYBOARD_EFFECTIVE_258 = 0x124; //01,0010,0100
		public static final int KEYBOARD_EFFECTIVE_147 = 0x092; //00,1001,0010
		public static final int KEYBOARD_EFFECTIVE_13579 = 0x2AA; //10,1010,1010
		public static final int KEYBOARD_EFFECTIVE_579 = 0x2A0; //10,1010,0000
		public static final int KEYBOARD_EFFECTIVE_1357 = 0x0AA; //00,1010,1010
		public static final int KEYBOARD_EFFECTIVE_ALL = 0x3FF; //11,1111,1111
		public static final int KEYBOARD_EFFECTIVE_NO = 0x000; //00,0000,0000
		
		public static final int KEYBOARD_EFFECTIVE_DEL = 0x400; //0,0100,0000,0000
		public static final int KEYBOARD_EFFECTIVE_CANCLE = 0x800; //0,1000,0000,0000
		public static final int KEYBOARD_EFFECTIVE_OK = 0x1000; //1,0000,0000,0000
}
