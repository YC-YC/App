package com.example.ycwideget;

import android.os.SystemClock;

/*
 * 控制刷新
 */
public class FreshCtrl {
	/*
	 * 提供接口供外部实现
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
	 * 数据变化提高请求速率，持续时间为FASTESTCONTINUE，在这时间内有更新即刷新
	 * FASTESTCONTINUE无更新则STANDARD请求
	 */
	public boolean fresh()
	{
		long currentTime = SystemClock.uptimeMillis();
		//超过请求持续时间
		if (currentTime - lastTime > FASTESTCONTINUE)
		{
			//恢复标准请求
			if (currentTime - lastRequestTime > STANDARD)
			{
				return doRequest(currentTime);
			}
		}
		else
		{
			//最快请求
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
