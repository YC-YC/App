/*
 * UartCom.h
 *
 *  Created on: 2016-1-13
 *      Author: YC
 */

#ifndef UARTCOM_H_
#define UARTCOM_H_
#include "comdef.h"

#define CLIENT_BUFF_SIZE	(1024)		//最大接收长度

class UartCom
{
public:
	UartCom();
	~UartCom();
	void ProcRxCmd(const BYTE* buf, int len);
private:
	void PrintBufferHex(const BYTE* buf, int len);
};


#endif /* UARTCOM_H_ */
