/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\YC\\Desktop\\�˿�BC8_�ں�PX2_API\\GocDemo\\src\\com\\goodocom\\gocsdk\\IGocsdkService.aidl
 */
package com.goodocom.gocsdk;
public interface IGocsdkService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.goodocom.gocsdk.IGocsdkService
{
private static final java.lang.String DESCRIPTOR = "com.goodocom.gocsdk.IGocsdkService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.goodocom.gocsdk.IGocsdkService interface,
 * generating a proxy if needed.
 */
public static com.goodocom.gocsdk.IGocsdkService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.goodocom.gocsdk.IGocsdkService))) {
return ((com.goodocom.gocsdk.IGocsdkService)iin);
}
return new com.goodocom.gocsdk.IGocsdkService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_GOCSDK_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
com.goodocom.gocsdk.IGocsdkCallback _arg0;
_arg0 = com.goodocom.gocsdk.IGocsdkCallback.Stub.asInterface(data.readStrongBinder());
this.GOCSDK_registerCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_unregisterCallback:
{
data.enforceInterface(DESCRIPTOR);
com.goodocom.gocsdk.IGocsdkCallback _arg0;
_arg0 = com.goodocom.gocsdk.IGocsdkCallback.Stub.asInterface(data.readStrongBinder());
this.GOCSDK_unregisterCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_getLocalName:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_getLocalName();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_setLocalName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_setLocalName(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_getPinCode:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_getPinCode();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_setPinCode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_setPinCode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_connectLast:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_connectLast();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_connectA2dp:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_connectA2dp(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_connectHFP:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_connectHFP(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_disconnect:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_disconnect();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_disconnectA2DP:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_disconnectA2DP();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_disconnectHFP:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_disconnectHFP();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_deletePair:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_deletePair(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_startDiscovery:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_startDiscovery();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_getPairList:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_getPairList();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_stopDiscovery:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_stopDiscovery();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_phoneAnswer:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_phoneAnswer();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_phoneHangUp:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_phoneHangUp();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_phoneDail:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_phoneDail(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_phoneTransmitDTMFCode:
{
data.enforceInterface(DESCRIPTOR);
char _arg0;
_arg0 = (char)data.readInt();
this.GOCSDK_phoneTransmitDTMFCode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_phoneTransfer:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_phoneTransfer();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_phoneTransferBack:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_phoneTransferBack();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_phoneBookStartUpdate:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_phoneBookStartUpdate();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_callLogstartUpdate:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.GOCSDK_callLogstartUpdate(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_musicPlayOrPause:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_musicPlayOrPause();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_musicStop:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_musicStop();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_musicPrevious:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_musicPrevious();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_musicNext:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_musicNext();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_PairMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.GOCSDK_PairMode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_ReDail:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_ReDail();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_MicSwitch:
{
data.enforceInterface(DESCRIPTOR);
char _arg0;
_arg0 = (char)data.readInt();
this.GOCSDK_MicSwitch(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryHfpStatus:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryHfpStatus();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_ResetBluetooth:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_ResetBluetooth();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryAutoConnectAccept:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryAutoConnectAccept();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_SetAutoConnect:
{
data.enforceInterface(DESCRIPTOR);
char _arg0;
_arg0 = (char)data.readInt();
this.GOCSDK_SetAutoConnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_SetAutoAccept:
{
data.enforceInterface(DESCRIPTOR);
char _arg0;
_arg0 = (char)data.readInt();
this.GOCSDK_SetAutoAccept(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryA2dpStatus:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryA2dpStatus();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryVersion:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryVersion();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_MuteOrUnmuteA2dp:
{
data.enforceInterface(DESCRIPTOR);
char _arg0;
_arg0 = (char)data.readInt();
this.GOCSDK_MuteOrUnmuteA2dp(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_UnmuteOrHalfA2dp:
{
data.enforceInterface(DESCRIPTOR);
char _arg0;
_arg0 = (char)data.readInt();
this.GOCSDK_UnmuteOrHalfA2dp(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_OppSendFile:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_OppSendFile(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_SppConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_SppConnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_SppSendData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_SppSendData(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_SppDisConnect:
{
data.enforceInterface(DESCRIPTOR);
char _arg0;
_arg0 = (char)data.readInt();
this.GOCSDK_SppDisConnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquirySppStatus:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquirySppStatus();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_HidConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_HidConnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_HidMouseMove:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_HidMouseMove(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_HidHomeKey:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_HidHomeKey();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_HidBackKey:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_HidBackKey();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_HidMenuKey:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_HidMenuKey();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_HidDisConnect:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_HidDisConnect();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryHidStatus:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryHidStatus();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_SetHidResolution:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_SetHidResolution(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_PauseMusic:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_PauseMusic();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_PanConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.GOCSDK_PanConnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_PanDisConnect:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_PanDisConnect();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryPanStatus:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryPanStatus();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryLocalAddr:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryLocalAddr();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_OpenBt:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_OpenBt();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_CloseBt:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_CloseBt();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryCurBtAddr:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryCurBtAddr();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryCurBtName:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryCurBtName();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquirySignelBatteryVal:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquirySignelBatteryVal();
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_SetMusicVal:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.GOCSDK_SetMusicVal(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_GOCSDK_InquiryMusicInfo:
{
data.enforceInterface(DESCRIPTOR);
this.GOCSDK_InquiryMusicInfo();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.goodocom.gocsdk.IGocsdkService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/*注册回调*/
@Override public void GOCSDK_registerCallback(com.goodocom.gocsdk.IGocsdkCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_GOCSDK_registerCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*注销回调*/
@Override public void GOCSDK_unregisterCallback(com.goodocom.gocsdk.IGocsdkCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_GOCSDK_unregisterCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*取得本地蓝牙名字*/
@Override public void GOCSDK_getLocalName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_getLocalName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*设置本地蓝牙名字*/
@Override public void GOCSDK_setLocalName(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_GOCSDK_setLocalName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*取得本地蓝牙密码*/
@Override public void GOCSDK_getPinCode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_getPinCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*设置本地蓝牙密码*/
@Override public void GOCSDK_setPinCode(java.lang.String pincode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(pincode);
mRemote.transact(Stub.TRANSACTION_GOCSDK_setPinCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*连接最后个已配对设备*/
@Override public void GOCSDK_connectLast() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_connectLast, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*连接指定蓝牙地址a2dp设备*/
@Override public void GOCSDK_connectA2dp(java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_GOCSDK_connectA2dp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*连接指定蓝牙地址hfp设备*/
@Override public void GOCSDK_connectHFP(java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_GOCSDK_connectHFP, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*断开a2dp & hfp连接*/
@Override public void GOCSDK_disconnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_disconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*断开a2dp连接*/
@Override public void GOCSDK_disconnectA2DP() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_disconnectA2DP, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*断开hfp连接*/
@Override public void GOCSDK_disconnectHFP() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_disconnectHFP, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*删除指定已配对蓝牙设备, isEmpty删除所有蓝牙设备*/
@Override public void GOCSDK_deletePair(java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_GOCSDK_deletePair, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*开始搜索设备*/
@Override public void GOCSDK_startDiscovery() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_startDiscovery, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*取得配对列表*/
@Override public void GOCSDK_getPairList() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_getPairList, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*停止搜索设备*/
@Override public void GOCSDK_stopDiscovery() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_stopDiscovery, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*接通电话*/
@Override public void GOCSDK_phoneAnswer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_phoneAnswer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*挂断电话/拒接电话*/
@Override public void GOCSDK_phoneHangUp() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_phoneHangUp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*拨打电话*/
@Override public void GOCSDK_phoneDail(java.lang.String phonenum) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(phonenum);
mRemote.transact(Stub.TRANSACTION_GOCSDK_phoneDail, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*拨打分机号*/
@Override public void GOCSDK_phoneTransmitDTMFCode(char code) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((int)code));
mRemote.transact(Stub.TRANSACTION_GOCSDK_phoneTransmitDTMFCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*语音切换到蓝牙*/
@Override public void GOCSDK_phoneTransfer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_phoneTransfer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*语音切换到手机*/
@Override public void GOCSDK_phoneTransferBack() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_phoneTransferBack, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*读取手机电话本*/
@Override public void GOCSDK_phoneBookStartUpdate() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_phoneBookStartUpdate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*
	       读取通话记录  
	  3 = 已拨号码
	  4 = 未接号码
	  5 = 已接号码
	*/
@Override public void GOCSDK_callLogstartUpdate(int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_GOCSDK_callLogstartUpdate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*播放/暂停音乐*/
@Override public void GOCSDK_musicPlayOrPause() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_musicPlayOrPause, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*停止音乐*/
@Override public void GOCSDK_musicStop() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_musicStop, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*上一曲*/
@Override public void GOCSDK_musicPrevious() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_musicPrevious, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*下一曲*/
@Override public void GOCSDK_musicNext() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_musicNext, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*
	1 = 进入配对
	2 = 取消配对
	*/
@Override public void GOCSDK_PairMode(int type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(type);
mRemote.transact(Stub.TRANSACTION_GOCSDK_PairMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*重拨号码*/
@Override public void GOCSDK_ReDail() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_ReDail, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*语言拨号*///void GOCSDK_VoiceDial();
/*取消语音拨号*///void CancelVoiceDial();
/*
		SPK+MIC音量调试
		volume[0] = spk
		volume[1] = mic
	*///void GOCSDK_VolumeSet(string volume);
/*麦克打开(1)/关闭(0)*/
@Override public void GOCSDK_MicSwitch(char type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((int)type));
mRemote.transact(Stub.TRANSACTION_GOCSDK_MicSwitch, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询hfp状态*/
@Override public void GOCSDK_InquiryHfpStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryHfpStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*复位蓝牙模块*/
@Override public void GOCSDK_ResetBluetooth() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_ResetBluetooth, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询自动接听和上电自动连接配置*/
@Override public void GOCSDK_InquiryAutoConnectAccept() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryAutoConnectAccept, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*设置上电自动连接('1')/取消自动连接('0')*/
@Override public void GOCSDK_SetAutoConnect(char type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((int)type));
mRemote.transact(Stub.TRANSACTION_GOCSDK_SetAutoConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*设置自动接听('1')/取消自动接听('0')*/
@Override public void GOCSDK_SetAutoAccept(char type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((int)type));
mRemote.transact(Stub.TRANSACTION_GOCSDK_SetAutoAccept, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询A2DP状态*/
@Override public void GOCSDK_InquiryA2dpStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryA2dpStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询版本日期*/
@Override public void GOCSDK_InquiryVersion() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryVersion, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*启动('1')/禁止('0')蓝牙音乐*/
@Override public void GOCSDK_MuteOrUnmuteA2dp(char type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((int)type));
mRemote.transact(Stub.TRANSACTION_GOCSDK_MuteOrUnmuteA2dp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*恢复('1')/减半('0')蓝牙音乐*/
@Override public void GOCSDK_UnmuteOrHalfA2dp(char type) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((int)type));
mRemote.transact(Stub.TRANSACTION_GOCSDK_UnmuteOrHalfA2dp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*通过OPP发送文件给手机*/
@Override public void GOCSDK_OppSendFile(java.lang.String path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
mRemote.transact(Stub.TRANSACTION_GOCSDK_OppSendFile, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*连接spp,isEmpty为连接当前spp*/
@Override public void GOCSDK_SppConnect(java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_GOCSDK_SppConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*发送spp数据
	  data[0] = spp index
	*/
@Override public void GOCSDK_SppSendData(java.lang.String data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(data);
mRemote.transact(Stub.TRANSACTION_GOCSDK_SppSendData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*断开spp*/
@Override public void GOCSDK_SppDisConnect(char index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((int)index));
mRemote.transact(Stub.TRANSACTION_GOCSDK_SppDisConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询spp状态*/
@Override public void GOCSDK_InquirySppStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquirySppStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*连接Hid, isEmpty为连接当前的hid*/
@Override public void GOCSDK_HidConnect(java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_GOCSDK_HidConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*Hid 鼠标移动
	  data[0] = key(1 = down 0 = up)
	  data[1]-data[4] = x
	  data[5]-data[8] = y
	*/
@Override public void GOCSDK_HidMouseMove(java.lang.String data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(data);
mRemote.transact(Stub.TRANSACTION_GOCSDK_HidMouseMove, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*HID home按键*/
@Override public void GOCSDK_HidHomeKey() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_HidHomeKey, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*HID back按键*/
@Override public void GOCSDK_HidBackKey() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_HidBackKey, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*HID menu按键*/
@Override public void GOCSDK_HidMenuKey() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_HidMenuKey, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*断开Hid*/
@Override public void GOCSDK_HidDisConnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_HidDisConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询hid状态*/
@Override public void GOCSDK_InquiryHidStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryHidStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*设置车机可投射区域分辨率
	  data[0]-data[3] = x
	  data[4]-data[7] = y
	*/
@Override public void GOCSDK_SetHidResolution(java.lang.String data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(data);
mRemote.transact(Stub.TRANSACTION_GOCSDK_SetHidResolution, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*强制暂停音乐*/
@Override public void GOCSDK_PauseMusic() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_PauseMusic, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*pan 连接, isEmpty为连接当前pan*/
@Override public void GOCSDK_PanConnect(java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_GOCSDK_PanConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*断开 pan*/
@Override public void GOCSDK_PanDisConnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_PanDisConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询pan状态*/
@Override public void GOCSDK_InquiryPanStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryPanStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询本地蓝牙地址*/
@Override public void GOCSDK_InquiryLocalAddr() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryLocalAddr, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*打开蓝牙设备*/
@Override public void GOCSDK_OpenBt() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_OpenBt, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*关闭蓝牙设备*/
@Override public void GOCSDK_CloseBt() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_CloseBt, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询当前连接设备地址*/
@Override public void GOCSDK_InquiryCurBtAddr() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryCurBtAddr, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询当前连接设备的蓝牙名*/
@Override public void GOCSDK_InquiryCurBtName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryCurBtName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询spk/mic音量值*///void GOCSDK_InquirySpkMicVal();
/*查询电池/信号量*/
@Override public void GOCSDK_InquirySignelBatteryVal() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquirySignelBatteryVal, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*设置蓝牙音乐音量 0 - 20*/
@Override public void GOCSDK_SetMusicVal(int val) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(val);
mRemote.transact(Stub.TRANSACTION_GOCSDK_SetMusicVal, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/*查询蓝牙音乐信息*/
@Override public void GOCSDK_InquiryMusicInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_GOCSDK_InquiryMusicInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_GOCSDK_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_GOCSDK_unregisterCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_GOCSDK_getLocalName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_GOCSDK_setLocalName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_GOCSDK_getPinCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_GOCSDK_setPinCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_GOCSDK_connectLast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_GOCSDK_connectA2dp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_GOCSDK_connectHFP = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_GOCSDK_disconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_GOCSDK_disconnectA2DP = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_GOCSDK_disconnectHFP = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_GOCSDK_deletePair = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_GOCSDK_startDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_GOCSDK_getPairList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_GOCSDK_stopDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_GOCSDK_phoneAnswer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_GOCSDK_phoneHangUp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_GOCSDK_phoneDail = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_GOCSDK_phoneTransmitDTMFCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_GOCSDK_phoneTransfer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_GOCSDK_phoneTransferBack = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_GOCSDK_phoneBookStartUpdate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_GOCSDK_callLogstartUpdate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_GOCSDK_musicPlayOrPause = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_GOCSDK_musicStop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_GOCSDK_musicPrevious = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_GOCSDK_musicNext = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_GOCSDK_PairMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_GOCSDK_ReDail = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_GOCSDK_MicSwitch = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_GOCSDK_InquiryHfpStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_GOCSDK_ResetBluetooth = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_GOCSDK_InquiryAutoConnectAccept = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_GOCSDK_SetAutoConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_GOCSDK_SetAutoAccept = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_GOCSDK_InquiryA2dpStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_GOCSDK_InquiryVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_GOCSDK_MuteOrUnmuteA2dp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_GOCSDK_UnmuteOrHalfA2dp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_GOCSDK_OppSendFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_GOCSDK_SppConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_GOCSDK_SppSendData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_GOCSDK_SppDisConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
static final int TRANSACTION_GOCSDK_InquirySppStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
static final int TRANSACTION_GOCSDK_HidConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
static final int TRANSACTION_GOCSDK_HidMouseMove = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
static final int TRANSACTION_GOCSDK_HidHomeKey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
static final int TRANSACTION_GOCSDK_HidBackKey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
static final int TRANSACTION_GOCSDK_HidMenuKey = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
static final int TRANSACTION_GOCSDK_HidDisConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
static final int TRANSACTION_GOCSDK_InquiryHidStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 51);
static final int TRANSACTION_GOCSDK_SetHidResolution = (android.os.IBinder.FIRST_CALL_TRANSACTION + 52);
static final int TRANSACTION_GOCSDK_PauseMusic = (android.os.IBinder.FIRST_CALL_TRANSACTION + 53);
static final int TRANSACTION_GOCSDK_PanConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 54);
static final int TRANSACTION_GOCSDK_PanDisConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 55);
static final int TRANSACTION_GOCSDK_InquiryPanStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 56);
static final int TRANSACTION_GOCSDK_InquiryLocalAddr = (android.os.IBinder.FIRST_CALL_TRANSACTION + 57);
static final int TRANSACTION_GOCSDK_OpenBt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 58);
static final int TRANSACTION_GOCSDK_CloseBt = (android.os.IBinder.FIRST_CALL_TRANSACTION + 59);
static final int TRANSACTION_GOCSDK_InquiryCurBtAddr = (android.os.IBinder.FIRST_CALL_TRANSACTION + 60);
static final int TRANSACTION_GOCSDK_InquiryCurBtName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 61);
static final int TRANSACTION_GOCSDK_InquirySignelBatteryVal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 62);
static final int TRANSACTION_GOCSDK_SetMusicVal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 63);
static final int TRANSACTION_GOCSDK_InquiryMusicInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 64);
}
/*注册回调*/
public void GOCSDK_registerCallback(com.goodocom.gocsdk.IGocsdkCallback callback) throws android.os.RemoteException;
/*注销回调*/
public void GOCSDK_unregisterCallback(com.goodocom.gocsdk.IGocsdkCallback callback) throws android.os.RemoteException;
/*取得本地蓝牙名字*/
public void GOCSDK_getLocalName() throws android.os.RemoteException;
/*设置本地蓝牙名字*/
public void GOCSDK_setLocalName(java.lang.String name) throws android.os.RemoteException;
/*取得本地蓝牙密码*/
public void GOCSDK_getPinCode() throws android.os.RemoteException;
/*设置本地蓝牙密码*/
public void GOCSDK_setPinCode(java.lang.String pincode) throws android.os.RemoteException;
/*连接最后个已配对设备*/
public void GOCSDK_connectLast() throws android.os.RemoteException;
/*连接指定蓝牙地址a2dp设备*/
public void GOCSDK_connectA2dp(java.lang.String addr) throws android.os.RemoteException;
/*连接指定蓝牙地址hfp设备*/
public void GOCSDK_connectHFP(java.lang.String addr) throws android.os.RemoteException;
/*断开a2dp & hfp连接*/
public void GOCSDK_disconnect() throws android.os.RemoteException;
/*断开a2dp连接*/
public void GOCSDK_disconnectA2DP() throws android.os.RemoteException;
/*断开hfp连接*/
public void GOCSDK_disconnectHFP() throws android.os.RemoteException;
/*删除指定已配对蓝牙设备, isEmpty删除所有蓝牙设备*/
public void GOCSDK_deletePair(java.lang.String addr) throws android.os.RemoteException;
/*开始搜索设备*/
public void GOCSDK_startDiscovery() throws android.os.RemoteException;
/*取得配对列表*/
public void GOCSDK_getPairList() throws android.os.RemoteException;
/*停止搜索设备*/
public void GOCSDK_stopDiscovery() throws android.os.RemoteException;
/*接通电话*/
public void GOCSDK_phoneAnswer() throws android.os.RemoteException;
/*挂断电话/拒接电话*/
public void GOCSDK_phoneHangUp() throws android.os.RemoteException;
/*拨打电话*/
public void GOCSDK_phoneDail(java.lang.String phonenum) throws android.os.RemoteException;
/*拨打分机号*/
public void GOCSDK_phoneTransmitDTMFCode(char code) throws android.os.RemoteException;
/*语音切换到蓝牙*/
public void GOCSDK_phoneTransfer() throws android.os.RemoteException;
/*语音切换到手机*/
public void GOCSDK_phoneTransferBack() throws android.os.RemoteException;
/*读取手机电话本*/
public void GOCSDK_phoneBookStartUpdate() throws android.os.RemoteException;
/*
	       读取通话记录  
	  3 = 已拨号码
	  4 = 未接号码
	  5 = 已接号码
	*/
public void GOCSDK_callLogstartUpdate(int type) throws android.os.RemoteException;
/*播放/暂停音乐*/
public void GOCSDK_musicPlayOrPause() throws android.os.RemoteException;
/*停止音乐*/
public void GOCSDK_musicStop() throws android.os.RemoteException;
/*上一曲*/
public void GOCSDK_musicPrevious() throws android.os.RemoteException;
/*下一曲*/
public void GOCSDK_musicNext() throws android.os.RemoteException;
/*
	1 = 进入配对
	2 = 取消配对
	*/
public void GOCSDK_PairMode(int type) throws android.os.RemoteException;
/*重拨号码*/
public void GOCSDK_ReDail() throws android.os.RemoteException;
/*语言拨号*///void GOCSDK_VoiceDial();
/*取消语音拨号*///void CancelVoiceDial();
/*
		SPK+MIC音量调试
		volume[0] = spk
		volume[1] = mic
	*///void GOCSDK_VolumeSet(string volume);
/*麦克打开(1)/关闭(0)*/
public void GOCSDK_MicSwitch(char type) throws android.os.RemoteException;
/*查询hfp状态*/
public void GOCSDK_InquiryHfpStatus() throws android.os.RemoteException;
/*复位蓝牙模块*/
public void GOCSDK_ResetBluetooth() throws android.os.RemoteException;
/*查询自动接听和上电自动连接配置*/
public void GOCSDK_InquiryAutoConnectAccept() throws android.os.RemoteException;
/*设置上电自动连接('1')/取消自动连接('0')*/
public void GOCSDK_SetAutoConnect(char type) throws android.os.RemoteException;
/*设置自动接听('1')/取消自动接听('0')*/
public void GOCSDK_SetAutoAccept(char type) throws android.os.RemoteException;
/*查询A2DP状态*/
public void GOCSDK_InquiryA2dpStatus() throws android.os.RemoteException;
/*查询版本日期*/
public void GOCSDK_InquiryVersion() throws android.os.RemoteException;
/*启动('1')/禁止('0')蓝牙音乐*/
public void GOCSDK_MuteOrUnmuteA2dp(char type) throws android.os.RemoteException;
/*恢复('1')/减半('0')蓝牙音乐*/
public void GOCSDK_UnmuteOrHalfA2dp(char type) throws android.os.RemoteException;
/*通过OPP发送文件给手机*/
public void GOCSDK_OppSendFile(java.lang.String path) throws android.os.RemoteException;
/*连接spp,isEmpty为连接当前spp*/
public void GOCSDK_SppConnect(java.lang.String addr) throws android.os.RemoteException;
/*发送spp数据
	  data[0] = spp index
	*/
public void GOCSDK_SppSendData(java.lang.String data) throws android.os.RemoteException;
/*断开spp*/
public void GOCSDK_SppDisConnect(char index) throws android.os.RemoteException;
/*查询spp状态*/
public void GOCSDK_InquirySppStatus() throws android.os.RemoteException;
/*连接Hid, isEmpty为连接当前的hid*/
public void GOCSDK_HidConnect(java.lang.String addr) throws android.os.RemoteException;
/*Hid 鼠标移动
	  data[0] = key(1 = down 0 = up)
	  data[1]-data[4] = x
	  data[5]-data[8] = y
	*/
public void GOCSDK_HidMouseMove(java.lang.String data) throws android.os.RemoteException;
/*HID home按键*/
public void GOCSDK_HidHomeKey() throws android.os.RemoteException;
/*HID back按键*/
public void GOCSDK_HidBackKey() throws android.os.RemoteException;
/*HID menu按键*/
public void GOCSDK_HidMenuKey() throws android.os.RemoteException;
/*断开Hid*/
public void GOCSDK_HidDisConnect() throws android.os.RemoteException;
/*查询hid状态*/
public void GOCSDK_InquiryHidStatus() throws android.os.RemoteException;
/*设置车机可投射区域分辨率
	  data[0]-data[3] = x
	  data[4]-data[7] = y
	*/
public void GOCSDK_SetHidResolution(java.lang.String data) throws android.os.RemoteException;
/*强制暂停音乐*/
public void GOCSDK_PauseMusic() throws android.os.RemoteException;
/*pan 连接, isEmpty为连接当前pan*/
public void GOCSDK_PanConnect(java.lang.String addr) throws android.os.RemoteException;
/*断开 pan*/
public void GOCSDK_PanDisConnect() throws android.os.RemoteException;
/*查询pan状态*/
public void GOCSDK_InquiryPanStatus() throws android.os.RemoteException;
/*查询本地蓝牙地址*/
public void GOCSDK_InquiryLocalAddr() throws android.os.RemoteException;
/*打开蓝牙设备*/
public void GOCSDK_OpenBt() throws android.os.RemoteException;
/*关闭蓝牙设备*/
public void GOCSDK_CloseBt() throws android.os.RemoteException;
/*查询当前连接设备地址*/
public void GOCSDK_InquiryCurBtAddr() throws android.os.RemoteException;
/*查询当前连接设备的蓝牙名*/
public void GOCSDK_InquiryCurBtName() throws android.os.RemoteException;
/*查询spk/mic音量值*///void GOCSDK_InquirySpkMicVal();
/*查询电池/信号量*/
public void GOCSDK_InquirySignelBatteryVal() throws android.os.RemoteException;
/*设置蓝牙音乐音量 0 - 20*/
public void GOCSDK_SetMusicVal(int val) throws android.os.RemoteException;
/*查询蓝牙音乐信息*/
public void GOCSDK_InquiryMusicInfo() throws android.os.RemoteException;
}
