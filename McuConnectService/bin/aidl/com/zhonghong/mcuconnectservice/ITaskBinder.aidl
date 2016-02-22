package com.zhonghong.mcuconnectservice;

import com.zhonghong.mcuconnectservice.ItaskCallback;

/*
 * Binder interface which Clients bind Service
 */
interface ITaskBinder{
	void registerCallback(ITaskCallback callback);	//registerCallback that service callback client
	void unregisterCallback(ITaskCallback callback);//unregister
	int getStatus();
	void postCmd(int cmd);
}