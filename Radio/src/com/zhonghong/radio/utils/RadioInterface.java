package com.zhonghong.radio.utils;

import java.util.List;

/**
 * @author YC
 * @time 2016-2-23 18:23:06
 */
public interface RadioInterface {
	
	/**
	 * @return 最小频率
	 */
	int getMinFreq();
	
	/**
	 * @return 最大频率
	 */
	int getMaxFreq();
	
	/**
	 * @return 当前频率
	 */
	int getCurFreq();
	/**
	 * 转换成用于显示的频率
	 */
	String getDisplayFreq(int freq);
	
	/**
	 * @param freq 设置当前频率
	 */
	void setCurFreq(int freq);
	
	/**
	 * @return 步进
	 */
	int getFreqStep();
	
	/**
	 * @return Seekbar的值
	 */
	int getSeekbarMax();
	
	/**
	 * @return 频率列表
	 */
	List<String> getFreqList();
	
	/**
	 * @return 列表个数
	 */
	int getFreqListNum();
	
	/**
	 * @return 获取列表选中项
	 */
	int getListSelItem();
	
	/**
	 * @param item 选中列表项，-1表示清除选中
	 */
	void selListItemFreq(int item);
	
	/**
	 * 为ListView指定项添加频率
	 * @param item
	 * @param freq
	 */
	void saveListItemFreq(int item, int freq);
	
	/**
	 * 获取步进
	 * @param bAdd true = 增加, false = 减小
	 * @return
	 */
	int getFreqForStep(boolean bAdd);
	
	/**
	 * @param freq 设置应用频率，如果要设到MCU需要调用另外接口
	 */
	void setFreq(int freq);
	
	/**
	 * @return 是否是FM波段
	 */
	boolean isFM();
	

	/**
	 * 设置默认频率
	 */
	void setDefaultFreq();
}
