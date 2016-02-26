package com.zhonghong.radio.utils;

import java.util.List;

/**
 * @author YC
 * @time 2016-2-23 下午6:23:06
 */
public interface RadioInterface {
	int getMinFreq();
	int getMaxFreq();
	int getCurFreq();
	String getDisplayFreq(int freq);	//将转换成显示的字符串
	void setCurFreq(int freq);
	int getFreqStep();
	int getSeekbarMax();
	List<String> getFreqList();
	int getFreqListNum();
	int getListSelItem();
	void selListItemFreq(int item);	//选择列表项并高亮,-1为取消高亮
	void saveListItemFreq(int item, int freq);	//保存当前频率到列表
	
	int getFreqForStep(boolean bAdd);	//步进生成新频率，bAdd为true前进，false后退
	void setFreq(int freq);	//设置频率
	boolean isFM();
}
