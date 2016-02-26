package com.zhonghong.radio.area;

/**
 * @author YC
 * @time 2016-2-26 上午10:17:34
 */
public interface AreaProcKey {
	int ProcKey_0(int freq, boolean bFM);
	int ProcKey_1(int freq, boolean bFM);
	int ProcKey_2(int freq, boolean bFM);
	int ProcKey_3(int freq, boolean bFM);
	int ProcKey_4(int freq, boolean bFM);
	int ProcKey_5(int freq, boolean bFM);
	int ProcKey_6(int freq, boolean bFM);
	int ProcKey_7(int freq, boolean bFM);
	int ProcKey_8(int freq, boolean bFM);
	int ProcKey_9(int freq, boolean bFM);
	int ProcKey_del(int freq, boolean bFM);
	int ProcKey_del_all(int freq, boolean bFM);
	int ProcKey_confirm(int freq, boolean bFM);	//返回补充的频率
	
}
