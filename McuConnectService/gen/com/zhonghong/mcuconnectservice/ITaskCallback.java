/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: F:\\GitHub\\App\\McuConnectService\\src\\com\\zhonghong\\mcuconnectservice\\ITaskCallback.aidl
 */
package com.zhonghong.mcuconnectservice;
public interface ITaskCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.zhonghong.mcuconnectservice.ITaskCallback
{
private static final java.lang.String DESCRIPTOR = "com.zhonghong.mcuconnectservice.ITaskCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.zhonghong.mcuconnectservice.ITaskCallback interface,
 * generating a proxy if needed.
 */
public static com.zhonghong.mcuconnectservice.ITaskCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.zhonghong.mcuconnectservice.ITaskCallback))) {
return ((com.zhonghong.mcuconnectservice.ITaskCallback)iin);
}
return new com.zhonghong.mcuconnectservice.ITaskCallback.Stub.Proxy(obj);
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
case TRANSACTION_MCUCallback:
{
data.enforceInterface(DESCRIPTOR);
this.MCUCallback();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.zhonghong.mcuconnectservice.ITaskCallback
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
@Override public void MCUCallback() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_MCUCallback, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_MCUCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void MCUCallback() throws android.os.RemoteException;
}
