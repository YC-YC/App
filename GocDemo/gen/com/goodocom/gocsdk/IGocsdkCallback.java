/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\YC\\Desktop\\¹Ë¿­BC8_ÖÚºèPX2_API\\GocDemo\\src\\com\\goodocom\\gocsdk\\IGocsdkCallback.aidl
 */
package com.goodocom.gocsdk;
public interface IGocsdkCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.goodocom.gocsdk.IGocsdkCallback
{
private static final java.lang.String DESCRIPTOR = "com.goodocom.gocsdk.IGocsdkCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.goodocom.gocsdk.IGocsdkCallback interface,
 * generating a proxy if needed.
 */
public static com.goodocom.gocsdk.IGocsdkCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.goodocom.gocsdk.IGocsdkCallback))) {
return ((com.goodocom.gocsdk.IGocsdkCallback)iin);
}
return new com.goodocom.gocsdk.IGocsdkCallback.Stub.Proxy(obj);
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
case TRANSACTION_onHfpDisconnected:
{
data.enforceInterface(DESCRIPTOR);
this.onHfpDisconnected();
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpConnected:
{
data.enforceInterface(DESCRIPTOR);
this.onHfpConnected();
reply.writeNoException();
return true;
}
case TRANSACTION_onCallSucceed:
{
data.enforceInterface(DESCRIPTOR);
this.onCallSucceed();
reply.writeNoException();
return true;
}
case TRANSACTION_onIncoming:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onIncoming(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onHangUp:
{
data.enforceInterface(DESCRIPTOR);
this.onHangUp();
reply.writeNoException();
return true;
}
case TRANSACTION_onTalking:
{
data.enforceInterface(DESCRIPTOR);
this.onTalking();
reply.writeNoException();
return true;
}
case TRANSACTION_onRingStart:
{
data.enforceInterface(DESCRIPTOR);
this.onRingStart();
reply.writeNoException();
return true;
}
case TRANSACTION_onRingStop:
{
data.enforceInterface(DESCRIPTOR);
this.onRingStop();
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpLocal:
{
data.enforceInterface(DESCRIPTOR);
this.onHfpLocal();
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpRemote:
{
data.enforceInterface(DESCRIPTOR);
this.onHfpRemote();
reply.writeNoException();
return true;
}
case TRANSACTION_onInPairMode:
{
data.enforceInterface(DESCRIPTOR);
this.onInPairMode();
reply.writeNoException();
return true;
}
case TRANSACTION_onExitPairMode:
{
data.enforceInterface(DESCRIPTOR);
this.onExitPairMode();
reply.writeNoException();
return true;
}
case TRANSACTION_onOutGoingOrTalkingNumber:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onOutGoingOrTalkingNumber(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onInitSucceed:
{
data.enforceInterface(DESCRIPTOR);
this.onInitSucceed();
reply.writeNoException();
return true;
}
case TRANSACTION_onConnecting:
{
data.enforceInterface(DESCRIPTOR);
this.onConnecting();
reply.writeNoException();
return true;
}
case TRANSACTION_onMusicPlaying:
{
data.enforceInterface(DESCRIPTOR);
this.onMusicPlaying();
reply.writeNoException();
return true;
}
case TRANSACTION_onMusicStopped:
{
data.enforceInterface(DESCRIPTOR);
this.onMusicStopped();
reply.writeNoException();
return true;
}
case TRANSACTION_onAutoConnectAccept:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
boolean _arg1;
_arg1 = (0!=data.readInt());
this.onAutoConnectAccept(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onCurrentAddr:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onCurrentAddr(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onCurrentName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onCurrentName(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onHfpStatus:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onHfpStatus(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onAvStatus:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onAvStatus(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onVersionDate:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onVersionDate(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onCurrentDeviceName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onCurrentDeviceName(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onCurrentPinCode:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onCurrentPinCode(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onA2dpConnected:
{
data.enforceInterface(DESCRIPTOR);
this.onA2dpConnected();
reply.writeNoException();
return true;
}
case TRANSACTION_onCurrentAndPairList:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.onCurrentAndPairList(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onA2dpDisconnected:
{
data.enforceInterface(DESCRIPTOR);
this.onA2dpDisconnected();
reply.writeNoException();
return true;
}
case TRANSACTION_onPhoneBook:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.onPhoneBook(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onSimBook:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.onSimBook(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onPhoneBookDone:
{
data.enforceInterface(DESCRIPTOR);
this.onPhoneBookDone();
reply.writeNoException();
return true;
}
case TRANSACTION_onSimDone:
{
data.enforceInterface(DESCRIPTOR);
this.onSimDone();
reply.writeNoException();
return true;
}
case TRANSACTION_onCalllogDone:
{
data.enforceInterface(DESCRIPTOR);
this.onCalllogDone();
reply.writeNoException();
return true;
}
case TRANSACTION_onCalllog:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
this.onCalllog(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onDiscovery:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.onDiscovery(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onDiscoveryDone:
{
data.enforceInterface(DESCRIPTOR);
this.onDiscoveryDone();
reply.writeNoException();
return true;
}
case TRANSACTION_onLocalAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onLocalAddress(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onSppData:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
this.onSppData(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onSppConnect:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onSppConnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onSppDisconnect:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onSppDisconnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onSppStatus:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onSppStatus(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onOppReceivedFile:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onOppReceivedFile(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onOppPushSuccess:
{
data.enforceInterface(DESCRIPTOR);
this.onOppPushSuccess();
reply.writeNoException();
return true;
}
case TRANSACTION_onOppPushFailed:
{
data.enforceInterface(DESCRIPTOR);
this.onOppPushFailed();
reply.writeNoException();
return true;
}
case TRANSACTION_onHidConnected:
{
data.enforceInterface(DESCRIPTOR);
this.onHidConnected();
reply.writeNoException();
return true;
}
case TRANSACTION_onHidDisconnected:
{
data.enforceInterface(DESCRIPTOR);
this.onHidDisconnected();
reply.writeNoException();
return true;
}
case TRANSACTION_onHidStatus:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onHidStatus(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onMusicInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.onMusicInfo(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onPanConnect:
{
data.enforceInterface(DESCRIPTOR);
this.onPanConnect();
reply.writeNoException();
return true;
}
case TRANSACTION_onPanDisconnect:
{
data.enforceInterface(DESCRIPTOR);
this.onPanDisconnect();
reply.writeNoException();
return true;
}
case TRANSACTION_onPanStatus:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onPanStatus(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.goodocom.gocsdk.IGocsdkCallback
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
@Override public void onHfpDisconnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onHfpDisconnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onHfpConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onHfpConnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onCallSucceed() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onCallSucceed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onIncoming(java.lang.String number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(number);
mRemote.transact(Stub.TRANSACTION_onIncoming, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//void onSecondIncoming(String number);

@Override public void onHangUp() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onHangUp, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onTalking() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onTalking, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onRingStart() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onRingStart, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onRingStop() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onRingStop, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onHfpLocal() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onHfpLocal, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onHfpRemote() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onHfpRemote, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onInPairMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onInPairMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onExitPairMode() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onExitPairMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//void onCallHold();
//void onHoldCurrentAcceptWaiting();
//void onInMeeting();
//void onHangUpHoldingWaiting();
//void onHangUpCurrentAcceptWaiting();
//void onIncomingName();

@Override public void onOutGoingOrTalkingNumber(java.lang.String number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(number);
mRemote.transact(Stub.TRANSACTION_onOutGoingOrTalkingNumber, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onInitSucceed() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onInitSucceed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onConnecting() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onConnecting, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onMusicPlaying() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onMusicPlaying, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onMusicStopped() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onMusicStopped, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//void onVoiceConnected ();
//void onVoiceDisconnected ();

@Override public void onAutoConnectAccept(boolean autoConnect, boolean autoAccept) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((autoConnect)?(1):(0)));
_data.writeInt(((autoAccept)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_onAutoConnectAccept, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onCurrentAddr(java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_onCurrentAddr, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onCurrentName(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_onCurrentName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onHfpStatus(int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_onHfpStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onAvStatus(int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_onAvStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onVersionDate(java.lang.String version) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(version);
mRemote.transact(Stub.TRANSACTION_onVersionDate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onCurrentDeviceName(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_onCurrentDeviceName, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onCurrentPinCode(java.lang.String code) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(code);
mRemote.transact(Stub.TRANSACTION_onCurrentPinCode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onA2dpConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onA2dpConnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onCurrentAndPairList(int index, java.lang.String name, java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
_data.writeString(name);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_onCurrentAndPairList, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onA2dpDisconnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onA2dpDisconnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onPhoneBook(java.lang.String name, java.lang.String number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeString(number);
mRemote.transact(Stub.TRANSACTION_onPhoneBook, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onSimBook(java.lang.String name, java.lang.String number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeString(number);
mRemote.transact(Stub.TRANSACTION_onSimBook, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onPhoneBookDone() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onPhoneBookDone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onSimDone() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onSimDone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onCalllogDone() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onCalllogDone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onCalllog(int type, java.lang.String number) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(type);
_data.writeString(number);
mRemote.transact(Stub.TRANSACTION_onCalllog, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onDiscovery(java.lang.String name, java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_onDiscovery, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onDiscoveryDone() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onDiscoveryDone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onLocalAddress(java.lang.String addr) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(addr);
mRemote.transact(Stub.TRANSACTION_onLocalAddress, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onSppData(int index, java.lang.String data) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
_data.writeString(data);
mRemote.transact(Stub.TRANSACTION_onSppData, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onSppConnect(int index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
mRemote.transact(Stub.TRANSACTION_onSppConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onSppDisconnect(int index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
mRemote.transact(Stub.TRANSACTION_onSppDisconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onSppStatus(int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_onSppStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onOppReceivedFile(java.lang.String path) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(path);
mRemote.transact(Stub.TRANSACTION_onOppReceivedFile, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onOppPushSuccess() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onOppPushSuccess, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onOppPushFailed() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onOppPushFailed, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onHidConnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onHidConnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onHidDisconnected() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onHidDisconnected, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onHidStatus(int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_onHidStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onMusicInfo(java.lang.String MusicName, java.lang.String artist) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(MusicName);
_data.writeString(artist);
mRemote.transact(Stub.TRANSACTION_onMusicInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onPanConnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onPanConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onPanDisconnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onPanDisconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onPanStatus(int status) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(status);
mRemote.transact(Stub.TRANSACTION_onPanStatus, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onHfpDisconnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onHfpConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onCallSucceed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onIncoming = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onHangUp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_onTalking = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_onRingStart = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_onRingStop = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_onHfpLocal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_onHfpRemote = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_onInPairMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_onExitPairMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_onOutGoingOrTalkingNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_onInitSucceed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_onConnecting = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_onMusicPlaying = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_onMusicStopped = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_onAutoConnectAccept = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_onCurrentAddr = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_onCurrentName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_onHfpStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_onAvStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_onVersionDate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_onCurrentDeviceName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_onCurrentPinCode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_onA2dpConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_onCurrentAndPairList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
static final int TRANSACTION_onA2dpDisconnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 27);
static final int TRANSACTION_onPhoneBook = (android.os.IBinder.FIRST_CALL_TRANSACTION + 28);
static final int TRANSACTION_onSimBook = (android.os.IBinder.FIRST_CALL_TRANSACTION + 29);
static final int TRANSACTION_onPhoneBookDone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 30);
static final int TRANSACTION_onSimDone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 31);
static final int TRANSACTION_onCalllogDone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 32);
static final int TRANSACTION_onCalllog = (android.os.IBinder.FIRST_CALL_TRANSACTION + 33);
static final int TRANSACTION_onDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 34);
static final int TRANSACTION_onDiscoveryDone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 35);
static final int TRANSACTION_onLocalAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 36);
static final int TRANSACTION_onSppData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 37);
static final int TRANSACTION_onSppConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 38);
static final int TRANSACTION_onSppDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 39);
static final int TRANSACTION_onSppStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 40);
static final int TRANSACTION_onOppReceivedFile = (android.os.IBinder.FIRST_CALL_TRANSACTION + 41);
static final int TRANSACTION_onOppPushSuccess = (android.os.IBinder.FIRST_CALL_TRANSACTION + 42);
static final int TRANSACTION_onOppPushFailed = (android.os.IBinder.FIRST_CALL_TRANSACTION + 43);
static final int TRANSACTION_onHidConnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 44);
static final int TRANSACTION_onHidDisconnected = (android.os.IBinder.FIRST_CALL_TRANSACTION + 45);
static final int TRANSACTION_onHidStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 46);
static final int TRANSACTION_onMusicInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 47);
static final int TRANSACTION_onPanConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 48);
static final int TRANSACTION_onPanDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 49);
static final int TRANSACTION_onPanStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 50);
}
public void onHfpDisconnected() throws android.os.RemoteException;
public void onHfpConnected() throws android.os.RemoteException;
public void onCallSucceed() throws android.os.RemoteException;
public void onIncoming(java.lang.String number) throws android.os.RemoteException;
//void onSecondIncoming(String number);

public void onHangUp() throws android.os.RemoteException;
public void onTalking() throws android.os.RemoteException;
public void onRingStart() throws android.os.RemoteException;
public void onRingStop() throws android.os.RemoteException;
public void onHfpLocal() throws android.os.RemoteException;
public void onHfpRemote() throws android.os.RemoteException;
public void onInPairMode() throws android.os.RemoteException;
public void onExitPairMode() throws android.os.RemoteException;
//void onCallHold();
//void onHoldCurrentAcceptWaiting();
//void onInMeeting();
//void onHangUpHoldingWaiting();
//void onHangUpCurrentAcceptWaiting();
//void onIncomingName();

public void onOutGoingOrTalkingNumber(java.lang.String number) throws android.os.RemoteException;
public void onInitSucceed() throws android.os.RemoteException;
public void onConnecting() throws android.os.RemoteException;
public void onMusicPlaying() throws android.os.RemoteException;
public void onMusicStopped() throws android.os.RemoteException;
//void onVoiceConnected ();
//void onVoiceDisconnected ();

public void onAutoConnectAccept(boolean autoConnect, boolean autoAccept) throws android.os.RemoteException;
public void onCurrentAddr(java.lang.String addr) throws android.os.RemoteException;
public void onCurrentName(java.lang.String name) throws android.os.RemoteException;
public void onHfpStatus(int status) throws android.os.RemoteException;
public void onAvStatus(int status) throws android.os.RemoteException;
public void onVersionDate(java.lang.String version) throws android.os.RemoteException;
public void onCurrentDeviceName(java.lang.String name) throws android.os.RemoteException;
public void onCurrentPinCode(java.lang.String code) throws android.os.RemoteException;
public void onA2dpConnected() throws android.os.RemoteException;
public void onCurrentAndPairList(int index, java.lang.String name, java.lang.String addr) throws android.os.RemoteException;
public void onA2dpDisconnected() throws android.os.RemoteException;
public void onPhoneBook(java.lang.String name, java.lang.String number) throws android.os.RemoteException;
public void onSimBook(java.lang.String name, java.lang.String number) throws android.os.RemoteException;
public void onPhoneBookDone() throws android.os.RemoteException;
public void onSimDone() throws android.os.RemoteException;
public void onCalllogDone() throws android.os.RemoteException;
public void onCalllog(int type, java.lang.String number) throws android.os.RemoteException;
public void onDiscovery(java.lang.String name, java.lang.String addr) throws android.os.RemoteException;
public void onDiscoveryDone() throws android.os.RemoteException;
public void onLocalAddress(java.lang.String addr) throws android.os.RemoteException;
public void onSppData(int index, java.lang.String data) throws android.os.RemoteException;
public void onSppConnect(int index) throws android.os.RemoteException;
public void onSppDisconnect(int index) throws android.os.RemoteException;
public void onSppStatus(int status) throws android.os.RemoteException;
public void onOppReceivedFile(java.lang.String path) throws android.os.RemoteException;
public void onOppPushSuccess() throws android.os.RemoteException;
public void onOppPushFailed() throws android.os.RemoteException;
public void onHidConnected() throws android.os.RemoteException;
public void onHidDisconnected() throws android.os.RemoteException;
public void onHidStatus(int status) throws android.os.RemoteException;
public void onMusicInfo(java.lang.String MusicName, java.lang.String artist) throws android.os.RemoteException;
public void onPanConnect() throws android.os.RemoteException;
public void onPanDisconnect() throws android.os.RemoteException;
public void onPanStatus(int status) throws android.os.RemoteException;
}
