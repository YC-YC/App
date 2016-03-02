package com.zhonghong.radio.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YC
 * @time 2016-2-23 ����6:29:12
 */
public class AM implements RadioInterface{

	/*public AM() {
		T.RadioValue.mAMFreqList.clear();
		T.RadioValue.mAMFreqList.add(522);
		T.RadioValue.mAMFreqList.add(603);
		T.RadioValue.mAMFreqList.add(999);
		T.RadioValue.mAMFreqList.add(1404);
		T.RadioValue.mAMFreqList.add(1620);
		T.RadioValue.mAMFreqList.add(522);
	}*/
	
	@Override
	public int getMinFreq() {
		return T.RadioValue.mMinAMFreq;
	}

	@Override
	public int getMaxFreq() {
		return T.RadioValue.mMaxAMFreq;
	}

	@Override
	public int getCurFreq() {
		return T.RadioValue.mCurAMFreq;
	}

	@Override
	public int getFreqStep() {
		return T.RadioValue.mAMStep;
	}

	@Override
	public void setCurFreq(int freq) {
		T.RadioValue.mCurAMFreq = freq;
	}

	@Override
	public int getSeekbarMax() {
		return T.RadioValue.mMaxAMFreq - T.RadioValue.mMinAMFreq;
	}

	@Override
	public String getDisplayFreq(int freq) {
		return ""+freq;
	}

	@Override
	public List<String> getFreqList() {
		List<String> list = new ArrayList<String>();
		for (int freq: T.RadioValue.mAMFreqList)
		{
			list.add(getDisplayFreq(freq));
		}
		/*list.add(getDisplayFreq(522));
		list.add(getDisplayFreq(603));
		list.add(getDisplayFreq(999));
		list.add(getDisplayFreq(1404));
		list.add(getDisplayFreq(1620));
		list.add(getDisplayFreq(522));*/
		return list;
	}
	
	@Override
	public int getListSelItem() {
		return T.RadioValue.mAMSelItem;
	}

	@Override
	public void selListItemFreq(int item) {
		T.RadioValue.mAMSelItem = item;
		if (item >= 0 && item < T.RadioValue.mAMFreqList.size())
		{
			T.RadioValue.mCurAMFreq = T.RadioValue.mAMFreqList.get(item);
		}
	}

	@Override
	public void saveListItemFreq(int item, int freq) {
		if (item >= T.RadioValue.mAMFreqList.size())
		{
			T.RadioValue.mAMFreqList.add(freq);
			T.RadioValue.mAMSelItem = item;
		}
		else
		{
			T.RadioValue.mAMSelItem = item;
			T.RadioValue.mAMFreqList.set(item, freq);
		}
	}

	@Override
	public int getFreqForStep(boolean bAdd) {
		int freq = T.RadioValue.mCurAMFreq;
		if (bAdd)
		{
			freq += T.RadioValue.mAMStep;
			if (freq > T.RadioValue.mMaxAMFreq)
			{
				freq = T.RadioValue.mMinAMFreq;
			}
		}
		else
		{
			freq -= T.RadioValue.mAMStep;
			if (freq < T.RadioValue.mMinAMFreq)
			{
				freq = T.RadioValue.mMaxAMFreq;
			}
		}
		return freq;
	}

	@Override
	public void setFreq(int freq) {
		T.RadioValue.mCurAMFreq = freq;
	}

	@Override
	public boolean isFM() {
		return false;
	}
	@Override
	public int getFreqListNum() {
		return T.RadioValue.mAMFreqList.size();
	}

	@Override
	public void setDefaultFreq() {
		T.RadioValue.mAMFreqList.clear();
		
		T.RadioValue.mAMFreqList.add(522);
		T.RadioValue.mAMFreqList.add(603);
		T.RadioValue.mAMFreqList.add(999);
		T.RadioValue.mAMFreqList.add(1404);
		T.RadioValue.mAMFreqList.add(1620);
		T.RadioValue.mAMFreqList.add(522);
		T.RadioValue.mAMSelItem = -1;		
		
		T.RadioValue.mCurAMFreq = 522;
		T.RadioValue.mBand = T.AM_1;
	}

}
