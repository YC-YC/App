package com.example.ycwideget;

import android.os.SystemClock;

/*
 * ����ˢ��
 */
public class FreshCtrl {
	/*
	 * �ṩ�ӿڹ��ⲿʵ��
	 */
	public interface Fresh{
		public boolean doFresh();
	}
	
	private Fresh mFresh;
	private int STANDARD = 0;
	private int FASTEST = 0;
	private int FASTESTCONTINUE = 0;
	
	private long lastTime = 0;
	private long lastRequestTime = 0;

	public FreshCtrl(Fresh fresh, int standard, int fastest, int fastestContinue)
	{
		mFresh = fresh;
		STANDARD = standard;
		FASTEST = fastest;
		FASTESTCONTINUE = fastestContinue;
	}
	
	/*
	 * ���ݱ仯����������ʣ�����ʱ��ΪFASTESTCONTINUE������ʱ�����и��¼�ˢ��
	 * FASTESTCONTINUE�޸�����STANDARD����
	 */
	public boolean fresh()
	{
		long currentTime = SystemClock.uptimeMillis();
		//�����������ʱ��
		if (currentTime - lastTime > FASTESTCONTINUE)
		{
			//�ָ���׼����
			if (currentTime - lastRequestTime > STANDARD)
			{
				return doRequest(currentTime);
			}
		}
		else
		{
			//�������
			if (currentTime - lastRequestTime > FASTEST)
			{
				return doRequest(currentTime);
			}
		}
		return false;
	}

	private boolean doRequest(long currentTime) {
		lastRequestTime = currentTime;
		if (mFresh.doFresh())
		{
			lastTime = SystemClock.uptimeMillis();
			return true;
		}
		return false;
	}
	
}
