package com.example.forev.mycodelibrary.service;

import android.os.RemoteException;


public class TestAidlServiceBinder extends ITestServiceAidl.Stub {
//    IService.Stub stub = new

    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public String getRemoteIp() throws RemoteException {
        System.out.println("aidl binder实现类：线程号:" + Thread.currentThread());
        return "10.155.19.240:8080";
    }


}
