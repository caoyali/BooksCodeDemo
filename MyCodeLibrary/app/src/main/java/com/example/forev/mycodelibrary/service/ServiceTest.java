package com.example.forev.mycodelibrary.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceTest extends Service {
    private static String TAG = "CAO_ServiceTest";
    private Context context;

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(TAG, "onStart...");
        context = getApplicationContext();
        super.onStart(intent, startId);
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate...");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy...");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind...");
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind...");
        return null;
    }
}
