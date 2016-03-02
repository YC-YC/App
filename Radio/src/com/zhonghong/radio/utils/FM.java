package com.zhonghong.radio.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YC
 * @time 2016-2-23 ����6:26:30
 */
public class FM implements RadioInterface {

	/*public FM() {
		T.RadioValue.mFMFreqList.clear();
		T.RadioValue.mFMFreqList.add(8750);
		T.RadioValue.mFMFreqList.add(9010);
		T.RadioValue.mFMFreqList.add(9810);
		T.RadioValue.mFMFreqList.add(10610);
		T.RadioValue.mFMFreqList.add(10800);
		T.RadioValue.mFMFreqList.add(8750);
	}*/
	
	@Override
	public int getMaxFreq() {
		return T.RadioValue.mMaxFMFreq;
	}

	@Override
	public int getCurFreq() {
		return T.RadioValue.mCurFMFreq;
	}

	@Override
	public int getMinFreq() {
		return T.RadioValue.mMinFMFreq;
	}

	@Override
	public int getFreqStep() {
		return T.RadioValue.mFMStep;
	}


	@Override
	public void setCurFreq(int freq) {
		T.RadioValue.mCurFMFreq = freq;
	}

	@Override
	public int getSeekbarMax() {
		return T.RadioValue.mMaxFMFreq - T.RadioValue.mMinFMFreq;
	}

	@Override
	public String getDisplayFreq(int freq) {
		return ("" + freq/100 + "." + (freq%100)/10 + "" + freq%10);
	}

	@Override
	public List<String> getFreqList() {
		List<String> list = new ArrayList<String>();
		for (int freq: T.RadioValue.mFMFreqList)
		{
			list.add(getDisplayFreq(freq));
		}
		return list;
	}

	@Override
	public int getListSelItem() {
		return T.RadioValue.mFMSelItem;
	}


	@Override
	public void selListItemFreq(int item) {
		T.RadioValue.mFMSelItem = item;
		if (item >= 0 && item < T.RadioValue.mFMFreqList.size())
		{
			T.RadioValue.mCurFMFreq = T.RadioValue.mFMFreqList.get(item);
		}
	}

	@Override
	public void saveListItemFreq(int item, int freq) {
		if (item >= T.RadioValue.mFMFreqList.size())
		{
			T.RadioValue.mFMFreqList.add(freq);
			T.RadioValue.mFMSelItem = item;
		}
		else
		{
			T.RadioValue.mFMSelItem = item;
			T.RadioValue.mFMFreqList.set(item, freq);
		}
	}

	@Override
	public int getFreqForStep(boolean bAdd) {
		int freq = T.RadioValue.mCurFMFreq;
		if (bAdd)
		{
			freq += T.RadioValue.mFMStep;
			if (freq > T.RadioValue.mMaxFMFreq)
			{
				freq = T.RadioValue.mMinFMFreq;
			}
		}
		else
		{
			freq -= T.RadioValue.mFMStep;
			if (freq < T.RadioValue.mMinFMFreq)
			{
				freq = T.RadioValue.mMaxFMFreq;
			}
		}
		return freq;
	}

	@Override
	public void setFreq(int freq) {
		T.RadioValue.mCurFMFreq = freq;
	}

	@Override
	public boolean isFM() {
		return true;
	}

	@Override
	public int getFreqListNum() {
		return T.RadioValue.mFMFreqList.size();
	}

	@Override
	public void setDefaultFreq() {
		T.RadioValue.mFMFreqList.clear();
		
		T.RadioValue.mFMFreqList.add(8750);
		T.RadioValue.mFMFreqList.add(9010);
		T.RadioValue.mFMFreqList.add(9810);
		T.RadioValue.mFMFreqList.add(10610);
		T.RadioValue.mFMFreqList.add(10800);
		T.RadioValue.mFMFreqList.add(8750);
		T.RadioValue.mFMSelItem = -1;
		
		T.RadioValue.mCurFMFreq = 8750;
		T.RadioValue.mBand = T.FM_1;
	}


}
