package com.zhonghong.radio.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author YC
 * @time 2016-2-25 ����3:01:44
 */
public class RadioDataUtils {

	
	
	/**
	 * 从配置文件中获取数据
	 */
	public static void getRadioAllInfo(Context context) {
		SharedPreferences pref = context.getSharedPreferences(T.RADIO_INFO_FILE, Context.MODE_PRIVATE);
	
		int FMsize = pref.getInt(T.RADIO_INFO_KEY_FM_FREQ_LIST_SIZE, 0);
		int AMsize = pref.getInt(T.RADIO_INFO_KEY_AM_FREQ_LIST_SIZE, 0);
		
		T.RadioValue.mFMFreqList.clear();
		T.RadioValue.mAMFreqList.clear();
		
		if (FMsize > 0 && AMsize > 0)//数据都不为0时才有效
		{
			T.RadioValue.mBand = pref.getInt(T.RADIO_INFO_KEY_BAND, T.FM_1);

			T.RadioValue.mCurFMFreq = pref.getInt(T.RADIO_INFO_KEY_FM_CURFREQ, T.RadioValue.mMinFMFreq);
			T.RadioValue.mCurAMFreq = pref.getInt(T.RADIO_INFO_KEY_AM_CURFREQ, T.RadioValue.mMinAMFreq);
			
			for (int i = 0; i < FMsize; i++)
			{
				T.RadioValue.mFMFreqList.add(pref.getInt(T.RADIO_INFO_KEY_FM_FREQ_LIST+i, T.RadioValue.mMinFMFreq));
			}
			T.RadioValue.mFMSelItem = pref.getInt(T.RADIO_INFO_KEY_FM_SELITEM, -1);
			
			for (int i = 0; i < AMsize; i++)
			{
				T.RadioValue.mAMFreqList.add(pref.getInt(T.RADIO_INFO_KEY_AM_FREQ_LIST+i, T.RadioValue.mMinAMFreq));
			}
			T.RadioValue.mAMSelItem = pref.getInt(T.RADIO_INFO_KEY_AM_SELITEM, -1);
		}
		else
		{
			setDefaultRadioInfo();
		}
		
	}
	
	/**
	 *设置默认配置信息
	 */
	private static void setDefaultRadioInfo() {
		
		T.RadioValue.mBand = T.FM_1;
		T.RadioValue.mCurFMFreq = T.RadioValue.mMinFMFreq;
		T.RadioValue.mCurAMFreq = T.RadioValue.mMinAMFreq;
		
		T.RadioValue.mFMFreqList.add(8750);
		T.RadioValue.mFMFreqList.add(9010);
		T.RadioValue.mFMFreqList.add(9810);
		T.RadioValue.mFMFreqList.add(10610);
		T.RadioValue.mFMFreqList.add(10800);
		T.RadioValue.mFMFreqList.add(8750);
		T.RadioValue.mFMSelItem = -1;
		
		T.RadioValue.mAMFreqList.add(522);
		T.RadioValue.mAMFreqList.add(603);
		T.RadioValue.mAMFreqList.add(999);
		T.RadioValue.mAMFreqList.add(1404);
		T.RadioValue.mAMFreqList.add(1620);
		T.RadioValue.mAMFreqList.add(522);
		T.RadioValue.mAMSelItem = -1;
	}
	

	/**
	 * 保存数据到配置文件
	 */
	public static void saveRadioAllInfo(Context context) {
		SharedPreferences pref = context.getSharedPreferences(T.RADIO_INFO_FILE, Context.MODE_PRIVATE);
		Editor editor = pref.edit();
		
		editor.putInt(T.RADIO_INFO_KEY_BAND, T.RadioValue.mBand);
		
		editor.putInt(T.RADIO_INFO_KEY_FM_CURFREQ, T.RadioValue.mCurFMFreq);
		editor.putInt(T.RADIO_INFO_KEY_AM_CURFREQ, T.RadioValue.mCurAMFreq);
		
		int FMSize = T.RadioValue.mFMFreqList.size();
		int AMSize = T.RadioValue.mAMFreqList.size();
		
		editor.putInt(T.RADIO_INFO_KEY_FM_FREQ_LIST_SIZE, FMSize);
		editor.putInt(T.RADIO_INFO_KEY_AM_FREQ_LIST_SIZE, AMSize);

		for (int i = 0; i < FMSize; i++)
		{
			editor.putInt(T.RADIO_INFO_KEY_FM_FREQ_LIST+i, T.RadioValue.mFMFreqList.get(i));
		}
		editor.putInt(T.RADIO_INFO_KEY_FM_SELITEM, T.RadioValue.mFMSelItem);
		
		for (int i = 0; i < AMSize; i++)
		{
			editor.putInt(T.RADIO_INFO_KEY_AM_FREQ_LIST+i, T.RadioValue.mAMFreqList.get(i));
		}
		editor.putInt(T.RADIO_INFO_KEY_AM_SELITEM, T.RadioValue.mAMSelItem);
		
		editor.commit();
	}
	
}
