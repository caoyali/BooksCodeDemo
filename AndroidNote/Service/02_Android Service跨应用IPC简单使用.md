# 跨应用服务

目前只是很简单的实现方式。在自学的过程中已经产生了大量的疑惑。之后会一个个的逐步击破。
前面我们学习了在应用内如何做到跨进程服务的。但是对于服务而言，其实你完全可以做到在自己的app内写一个公共的服务，提供给其他应用去用的。这里就涉及了跨应用之间的服务。下面看看怎么实现

### 实现方案
首先我们想一下，对于服务而言，会有两个非常必要的角色，就是 服务提供者app1--服务端， 服务使用者app2--客户端。

所以因为这两个角色的存在，我们得写两个应用。

再怎么跨应用，大致的流程应该和前面学的应用内跨进程服务是一样的。只不过有一些细节需要我们注意一下而已。
[实现代码请点击查看](../../ServiceIpcDemo/app/src/main/java/com/example/serviceipcdemo/TestIPCFeatureServiceBinder.java)

#### app1-服务提供者实现
##### aidl文件
文件位置如图所示，注意看看，后面会讲：
<a href="https://sm.ms/image/BusrGClwzJgO2EX" target="_blank"><img src="https://i.loli.net/2021/08/10/BusrGClwzJgO2EX.png" width= 300></a>

这个文件的具体内容如下。
```java
// TestIPCFeatureService.aidl
package com.example.serviceipcdemo; //这个包名就是上方文件夹的名字，保持一致的。记住这个细节。之后会有用！

// Declare any non-default types here with import statements

interface TestIPCFeatureService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    long getCurrentThreadId();
    void play();
    void pause();
}
```
##### 生成aidl的实现类
我们点击build一下，就自然会在对应的文件夹下生成这个类的相关接口。这里面有我们非常需要的binder类。
```java
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
```
就酱，特简单。随便写写就成了，这都不是重点。

##### 写service！
这个其实也是相当简单的，套路与之前的一致。
```java
package com.example.serviceipcdemo;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class TestIPCService extends Service {

    private static final String TAG = "CAO_" + TestIPCService.class.getName();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        return new TestIPCFeatureServiceBinder();
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d(TAG, "onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        Log.d(TAG, "onLowMemory()");
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        Log.d(TAG, "onTrimMemory()");
        super.onTrimMemory(level);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind()");
        super.onRebind(intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.d(TAG, "onTaskRemoved()");
        super.onTaskRemoved(rootIntent);
    }
}

```
核心就是一点，实现Service的onBinder方法，将你的实现类返回出去！
而对于这个实现类，以及这个类的对象怎么被传出去的，和客户端如何做到像平常调用代码那样就完成了跨进程调用的。这是一个十分庞大，复杂，且核心的内容! 任重道远同学！一步一个脚印慢慢踩吧！

##### 最后将你写的服务注册到Android manifest中
```xml
 <?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.serviceipcdemo">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.ServiceIpcDemo" >
        <service android:name=".TestIPCService"
            android:exported="true" //可以被外部外接
            android:enabled="true"
            android:process=":TestIPCService"> //进程名注意哈，别跟别家的服务重名
            <intent-filter>
                <action android:name="com.example.serviceipcdemo.testipcfeatureservice"/>
            </intent-filter>
        </service>
    </application>

</manifest>
```

就此服务端看似完活了！

#### app2-客户端
来再创一个项目，写一下客户端如何开启刚才写的服务的。 我觉的最初想的时候，你可能心里会说，这不很简单吗，但是我写的时候，的的确确感觉到碰到了一些意想不到的问题。我会在最后面将问题的详情写下来。

##### 思考
想象一下你实现的话， 是不是得写一个相关的connector？然后我们可以从这个connector中获取app1应用中的binder。然后调用binder的相关方法。觉得万事大吉了？我想当你想到这个环节的时候，你是否已经隐隐觉得这里面好像有的地方有点不对劲啊！-- 我怎么识别app1中的binder？我的项目连这个类都没有啊！

是的，这就是我们不得不碰到的一个很重要的问题--让自己的项目能够识别app1发过来的binder！
解决方案当然是现成的！那就是，
- 创建一个一模一样的aidl目录，注意是一模一样的目录结构。将app1中的那个aidl文件原封不动的拷贝过来。
- 点击build生成这个aidl的相关接口
- 还需要实现这个接口么？答案是不用！我们在客户端只需要想办法能够越过编译器拿到binder句柄并调用就行了。根本没有必要实现。

好，接下来进入实现环节。
##### aidl拷贝
<a href="https://sm.ms/image/mXTiOBZMgdECyqo" target="_blank"><img src="https://i.loli.net/2021/08/10/mXTiOBZMgdECyqo.png" width=300 ></a>
看看这个位置，与app1中的位置，是不是一模一样！这个是必须的哈！否则运行的时候会崩溃的！

aial内容，就是复制粘贴！
```java
// TestIPCFeatureService.aidl.aidl
package com.example.serviceipcdemo;

// Declare any non-default types here with import statements

interface TestIPCFeatureService {
    /**
         * Demonstrates some basic types that you can use as parameters
         * and return values in AIDL.
         */
        void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
                double aDouble, String aString);

        long getCurrentThreadId();
        void play();
        void pause();
}
```

##### 客户端调用
我在这里是指定了包名和类名调用的，其实还有其他的调用方式。简单暴力就这么调用了！
```java
 case R.id.mBindAppIpcService:
                Intent bindAppIpcServiceIntent = new Intent();
                bindAppIpcServiceIntent.setComponent(new ComponentName("com.example.serviceipcdemo",
                        "com.example.serviceipcdemo.TestIPCService"));
                bindService(bindAppIpcServiceIntent, mAppServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.mUnBindAppIpcService:
                unbindService(mAppServiceConnection);
                break;
```

```java
private ServiceConnection mAppServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "mAppServiceConnection onServiceConnected, ComponentName=" + name.toString());
            TestIPCFeatureService binder = TestIPCFeatureService.Stub.asInterface(service);
            try {
                binder.play();
                binder.getCurrentThreadId();
                binder.pause();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
```

### 思考跨应用服务一般使用场景为何？
这个答案竟然在网上找不到！what？同学们在不明作用的情况下学习，确定以后真的能够用得好他们吗？我有时候想吐槽啊。

那我们退而求其次，就单单提服务！它是在什么时候用！
主要用于处理一些耗时的任务。一般而言呢？耗时任务，咱们用线程也能实现呀。那么这些任务，在通常面向用户的开发中，究竟是哪些任务呢？

对于一些特殊的场景，例如进程保活,使用第三方sdk比如地图，IM等，这些都需要用service来进行实现，这些服务一般要与主进程隔离开。并且主进程即使发生崩溃也不应对服务造成影响。我觉的最后一句精辟！

#### 遇到的问题
写代码的时候遇到一个开不起服务的问题。系统报错如下：
Service starting has been prevented by iaware or trustsbase
这个问题呀，挺刁钻的。我找网上也没有找到靠谱的方案。根本就不是他们说的那回事。
搞了半天是华为独有的问题。这个原因是刚刚写的那个另一个app中的服务被手机系统禁止启动了。真坑啊。怎么解决呢？ <font color=pink>尝试在设置-应用-应用启动管理-选择对应程序，点击右边手动管理选项，把上面启动选项都打开再试试</font>
如图：
<a href="https://sm.ms/image/Bc9pAfGPDUHzIQM" target="_blank"><img src="https://i.loli.net/2021/08/10/Bc9pAfGPDUHzIQM.png" width = 200></a>

###小结
<font color=#B8860B font=blod>跨应用服务相比应用内服务不同之处在于，我们要原封不动的拷贝aidl的目录和文件，已解决编辑代码报错的问题。其余的应该还好！</color>

# 整体总结，代表康奈尔第三节。
