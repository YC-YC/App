/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: F:\\GitHub\\App\\McuConnectService\\src\\com\\zhonghong\\mcuconnectservice\\ITaskBinder.aidl
 */
package com.zhonghong.mcuconnectservice;
/*
 * Binder interface which Clients bind Service
 */
public interface ITaskBinder extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.zhonghong.mcuconnectservice.ITaskBinder
{
private static final java.lang.String DESCRIPTOR = "com.zhonghong.mcuconnectservice.ITaskBinder";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.zhonghong.mcuconnectservice.ITaskBinder interface,
 * generating a proxy if needed.
 */
public static com.zhonghong.mcuconnectservice.ITaskBinder asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.zhonghong.mcuconnectservice.ITaskBinder))) {
return ((com.zhonghong.mcuconnectservice.ITaskBinder)iin);
}
return new com.zhonghong.mcuconnectservice.ITaskBinder.Stub.Proxy(obj);
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
case TRANSACTION_registerCallback:
{
data.enforceInterface(DESCRIPTOR);
com.zhonghong.mcuconnectservice.ITaskCallback _arg0;
_arg0 = com.zhonghong.mcuconnectservice.ITaskCallback.Stub.asInterface(data.readStrongBinder());
this.registerCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_unregisterCallback:
{
data.enforceInterface(DESCRIPTOR);
com.zhonghong.mcuconnectservice.ITaskCallback _arg0;
_arg0 = com.zhonghong.mcuconnectservice.ITaskCallback.Stub.asInterface(data.readStrongBinder());
this.unregisterCallback(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getStatus:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getStatus();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_postCmd:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.postCmd(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.zhonghong.mcuconnectservice.ITaskBinder
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
@Override public void registerCallback(com.zhonghong.mcuconnectservice.ITaskCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//registerCallback that service callback client

@Override public void unregisterCallback(com.zhonghong.mcuconnectservice.ITaskCallback callback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregisterCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//unregister

@Override public int getStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getStatus, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void postCmd(int cmd) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(cmd);
mRemote.transact(Stub.TRANSACTION_postCmd, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_unregisterCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_postCmd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public void registerCallback(com.zhonghong.mcuconnectservice.ITaskCallback callback) throws android.os.RemoteException;
//registerCallback that service callback client

public void unregisterCallback(com.zhonghong.mcuconnectservice.ITaskCallback callback) throws android.os.RemoteException;
//unregister

public int getStatus() throws android.os.RemoteException;
public void postCmd(int cmd) throws android.os.RemoteException;
}
