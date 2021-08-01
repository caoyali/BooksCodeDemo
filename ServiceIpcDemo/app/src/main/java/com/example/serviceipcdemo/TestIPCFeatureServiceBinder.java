package com.example.serviceipcdemo;

import android.os.RemoteException;
import android.util.Log;

public class TestIPCFeatureServiceBinder extends TestIPCFeatureService.Stub {
    private final static String TAG = "CAO_" + TestIPCFeatureServiceBinder.class.getName();

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public long getCurrentThreadId() throws RemoteException {
        Log.d(TAG, "getCurrentThreadId");
        return Thread.currentThread().getId();
    }

    @Override
    public void play() throws RemoteException {
        Log.d(TAG, "Begin play...");
    }

    @Override
    public void pause() throws RemoteException {
        Log.d(TAG, "Begin pause...");
    }
}
