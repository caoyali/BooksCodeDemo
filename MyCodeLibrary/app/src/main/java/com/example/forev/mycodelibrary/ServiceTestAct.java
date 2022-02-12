package com.example.forev.mycodelibrary;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.example.forev.mycodelibrary.service.ServiceTest;

import butterknife.OnClick;

public class ServiceTestAct extends BaseActivity {
    private static final String TAG = "CAO_ServiceTestAct";
    TestIPCFeatureService.Stub mTestIPCFeatureServiceBinder;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected...");
            //bug binding之后不回调这个方法，有些费解，正在找答案，希望有个总结之类的。
            mTestIPCFeatureServiceBinder = (TestIPCFeatureService.Stub) TestIPCFeatureService.Stub.asInterface(service);
            try {
                long remoteThreadId = mTestIPCFeatureServiceBinder.getCurrentThreadId();
                Log.d(TAG, "远程的线程id为：" + remoteThreadId);
                mTestIPCFeatureServiceBinder.play();
                mTestIPCFeatureServiceBinder.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected...");
            mTestIPCFeatureServiceBinder = null;
        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.activity_test_service;
    }

    @Override
    protected void initView() {

//        Intent intent2 = new Intent(this, ServiceTest.class);
//        startService(intent2);
//        Intent intent3 = new Intent(this, ServiceTest.class);
//        startService(intent3);
//
//        Intent startIntentAgain = new Intent(this, ServiceTest.class);
//        startService(startIntentAgain);

//                2019-03-18 11:12:22.324 11568-11568/.myDemo I/ServiceTest: onCreate...
//                2019-03-18 11:12:22.325 11568-11568/.myDemo I/ServiceTest: onStartCommand...
//                2019-03-18 11:12:22.325 11568-11568/.myDemo I/ServiceTest: onStart...
//                2019-03-18 11:12:22.328 11568-11568/.myDemo I/ServiceTest: onStartCommand...
//                2019-03-18 11:12:22.328 11568-11568/.myDemo I/ServiceTest: onStart...
//                2019-03-18 11:12:22.329 11568-11568/.myDemo I/ServiceTest: onStartCommand...
//                2019-03-18 11:12:22.329 11568-11568/.myDemo I/ServiceTest: onStart...
//                2019-03-18 11:12:22.330 11568-11568/.myDemo I/ServiceTest: onDestroy...
//                2019-03-18 11:12:22.332 11568-11568/.myDemo I/ServiceTest: onCreate...
//                2019-03-18 11:12:22.333 11568-11568/.myDemo I/ServiceTest: onStartCommand...
//                2019-03-18 11:12:22.333 11568-11568/.myDemo I/ServiceTest: onStart...
        //以startService的形式开启。
        // 无论start多少次，只会调用一次onCreate，直至被 stop.stop的时候会执行onDestroy
    }

    @OnClick({R.id.mBindServer, R.id.mUnbindServic, R.id.mStartService, R.id.mFinish, R.id.mAidlService, R.id.mStopServiceBtn})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBindServer:
                Log.d(TAG, "用户点击绑定服务按钮。");
                Intent intent = new Intent();
                //不知道为什么就是开不了这个，这是怎么回事？
                intent.setAction("com.example.serviceipcdemo.testipcfeatureservice");
                intent.setPackage("com.example.serviceipcdemo");
                bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.mUnbindServic:
                unbindService(mServiceConnection);
                break;
            case R.id.mStartService:
                Intent intent1 = new Intent(this, ServiceTest.class);
                startService(intent1);
                break;
            case R.id.mStopServiceBtn:
                Intent stopIntent = new Intent(this, ServiceTest.class);
                stopService(stopIntent);
                break;
            case R.id.mFinish:
                break;
            case R.id.mAidlService:

                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mServiceConnection = null;
    }
}
