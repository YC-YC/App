package com.zhonghong.radio.utils;

import java.util.List;

/**
 * @author YC
 * @time 2016-2-23 ����6:23:06
 */
public interface RadioInterface {
	int getMinFreq();
	int getMaxFreq();
	int getCurFreq();
	String getDisplayFreq(int freq);	//��ת������ʾ���ַ���
	void setCurFreq(int freq);
	int getFreqStep();
	int getSeekbarMax();
	List<String> getFreqList();
	int getFreqListNum();
	int getListSelItem();
	void selListItemFreq(int item);	//ѡ���б������,-1Ϊȡ������
	void saveListItemFreq(int item, int freq);	//���浱ǰƵ�ʵ��б�
	
	int getFreqForStep(boolean bAdd);	//����������Ƶ�ʣ�bAddΪtrueǰ����false����
	void setFreq(int freq);	//����Ƶ��
	boolean isFM();
}
