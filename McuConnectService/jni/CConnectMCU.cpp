/*
 * ConnectMCU.cpp
 *
 *  Created on: 2016-1-12
 *      Author: YC
 */

#include "CConnectMCU.h"
#include "debug.h"

static CConnectMCU* g_pCConnectMCU = NULL;

static void ProcUartRxTemp(const BYTE* buff, int len)
{
	if (g_pCConnectMCU != NULL)
	{
		g_pCConnectMCU->GetUartCom()->ProcRxCmd(buff, len);
	}
}

CConnectMCU::CConnectMCU()
{
	g_pCConnectMCU = this;
	mUartCom = new UartCom();
	mUart = new CUartCtrl();
	OpenUart();
}
CConnectMCU::~CConnectMCU()
{
	if (mUart != NULL)
	{
		delete mUart;
		mUart = NULL;
	}
	if (mUartCom != NULL)
	{
		delete mUartCom;
		mUartCom = NULL;
	}
	g_pCConnectMCU = NULL;
}

UartCom* CConnectMCU::GetUartCom()
{
	return mUartCom;
}

const char* CConnectMCU::GetBlueToothVersion()
{
	return "1.0";
}

void CConnectMCU::OpenUart()	//打开串口
{
	LOGI("OpenUart\r\n");
	if (mUart != NULL)
	{
		LOGI("mUart != NULL\r\n");
		if (!mUart->IsOpen())
		{
			LOGI("!mUart->IsOpen()\r\n");
			mUart->OpenUart(BLUETOOTH_UART_NAME, BLUETOOTH_UART_BAUD);
			mUart->RegRxFun(ProcUartRxTemp);
		}
	}
}
void CConnectMCU::CloseUart()
{
	if (mUart != NULL)
	{
		if (mUart->IsOpen())
		{
			mUart->CloseUart();
		}
	}
}
