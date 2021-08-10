# Android aidl的简单使用
Android aidl实际上之前只是看别人写过这个，但是自己却没有真正的用过。随着技术学习的不断深入，这种东西，是有必要去学习的。
我之前的学习存在一个比较重要的缺陷，就是只是关注学习本身，但是从来没有什么精确的产出结果，这种学习方式，速度是比较快，但是我体会出一下几个缺陷：
1 研究的不深入
2 印象并不深刻，过一段时间就会忘掉
3 之后的复习过程中由于并没有很明确的产出，于是还得从头百度，但是百度出来的内容质量稂莠不齐，且文章作者水平不尽相同，最坏情况下，会出现花大量时间去找却找不出答案的情况。
4 没有精确的产出的另一个含义实则是没有清晰的目标，这样的学习过程很容易出现跑偏的现象。所以建议点到为止。之后的文章亦如此。

好吧。那我们接下来开启Service的学习。学习一个东西，我比较习惯的方式是，先从如何使用入手。然后不断的引申问题，去了解。

## ALDL的使用

aldl如果不搞跨进程的话，写这个也没什么意思了哈。所以我们在这里搞得是跨进程的那个！

**aidl接口文件，aidl实现类， Service, ServiceConnection, Intent**

- 1 **aidl接口文件**，这个文件是必须的。
- 2 **aidl接口实现类**，里面的xxx.stub指的就是我们常常提到的binder，Binder是一个比较大的知识模块，这个等到深入研究了自然会学到。
- 3 **Service实现类**， 用于bind时吐出该Service的binder，以便于跨进程
- 4 **ServiceSonnection** 实现类，用于开启Service的所属进程获得Binder实现类的具柄，拿到这个句柄之后就可以开始跨进程干活了。
- 5 开启一个Service的方式，以及其生命周期。

### 应用内服务

Android大家都知道的一个是，要跨进程，就要涉及到，binder。而我们为什么要写aidl呢？原因也是binder。是用它来生成一个binder的子类接口。自动生成接口之后，用户需要实现这个接口。而这个接口的实现类，就是一个binder。之后Service会有方法让被调用者拿到这个binder。拿到之后，进行类型强转，之后就可以拿这个binder做一些列操作。从而完成跨进程调用了。

- 首先先写一个aidl 文件。 怎么创建呢？如图这样点。

<a href="https://sm.ms/image/GIaCUEkogZqMRuA" target="_blank"><img src="https://i.loli.net/2021/07/29/GIaCUEkogZqMRuA.png" width=500></a>

  命名完之后，就会生成一个特定的文件夹 main/aidl/你的包名相当于拷贝的链路/service 文件夹/你刚才建立的文件.aidl
  这个里面的内容是这个样子的


```java
interface ItestServiceAidl{
    // 这个方法是默认生成的，其实可以去掉。这段代码根本就没有用，可以删除。
    void basicTypes(int anInt, long aLong, boolean aBoolean, floadt aFloat, double aDouble, String aString);

    // 这个是我自己新增的
    String getRemoteIp();
}
```

- 点击build按钮，让代码执行一些自动生成的逻辑。之后，会在build文件夹的一个很深的地方，生成对应的.java文件。名字与ItestServiceAidl保持一致。 这个文件有一个很重要的生成类： Stub   它很明显继承于Binder！ 这个就是以后我们会用到的一个重要的东西。
- 写刚刚说的Stub的实现类。我是这样实现的。


```java
public class TestAidlServiceBinder extends ITestServiceAidl.Stub {
//    IService.Stub stub = new

    @Override
    public String getRemoteIp() throws RemoteException {
        Log.d("ServiceTest", "aidl binder实现类：线程号:" + Thread.currentThread() + " 进程名：" + ProcessUtil.getCurrentProcessNameByApplication());
        return "10.155.19.240:8080";
    }
}
```

- 到此为止，我们只是实现了aidl相关的部分。但是我们写一个Service如何利用这个东西呢？接下来重点讲的是两个之间的关联方式。
- 写一个自定义的service
```java
public class ServiceTest extends Service {
    private static String TAG = "ServiceTest";
    // 这个就是刚刚我们自己实现的实现类。
    private TestAidlServiceBinder binder = new TestAidlServiceBinder();
    private Context context;

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(TAG, "onStart...");
        Handler handler = new Handler();
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

    /**
    * 这块是一个非常重要的点。看没看见， 我们把自己的binder，作为返回值，传出去了！
    * 那么它最终会落到哪里呢？
    */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind...");
        return binder;
    }

    private final IRemoteService.Stub iRemoteServiceStub = new IRemoteService.Stub() {

        @Override
        public int getPid() throws RemoteException {
            return 0;
        }
    };
}

```

- 客户端绑定服务，然后拿到Service刚才返回的binder。
客户端在绑定服务的时候，是可以传一个回调对象的。ServiceConnection ， 这个东西会在服务连上的时候，回调onServiceConnected（）方法， 里面有一个参数是IBinder！ 这个就是你刚刚在服务中传出去的那个Binder（严格点是：TestAidlServiceBinder！）但是拿到这个参数的时候，你不能走平常的强转方式，而是用aidl生成的那个类的相关方法给”反解“了。
- 接下来我们实现一下ServiceConnection 以便拿到binder句柄。

```java
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected...");
            // 用的正是aidl的生成类，来转换的！看来这个东西提供的能力挺配套的。很方便。
            ITestServiceAidl  testServiceAidl = ITestServiceAidl.Stub.asInterface(service);

//错！ 以下这种是错误示范！不要强转！
//            ServiceTest.MyBinder binder = (ServiceTest.MyBinder) service;
//            mServiceTest = binder.getService();
            try {
                String string = testServiceAidl.getRemoteIp();
                System.out.println("在ServiceTestAct中的线程是：：" + Thread.currentThread() + " string=" + string + " 进程名：" + ProcessUtil.getCurrentProcessNameByApplication());

            } catch (Exception e) {

            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected...");
        }
    };
```

- 好，万事俱备，只欠东风。 名场面来了
```java
            case R.id.mBindServer:
//                Intent intent = new Intent("com.android.aidl.action.MY_REMOTE_SERVICE");
//                intent.setPackage(getPackageName()); //隐式调用的时候，这行代码得加上去
//                intent.setAction();// 隐式意图,指定访问服务的action,就是被调用服务进程值注册服务的时候指定的action的值

                // 隐式调用和显示调用都是可以的，这个和是否跨进程之间一点关系都没有。
                Intent intent = new Intent(this, ServiceTest.class);
                bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
                break;

``` 

**但是仅仅有以上的代码，你压根就没办法做到跨进程的。是不是跨进程的关键是，在声明 Service 的 AndroidManifest.xml 文件中怎么写的。**

我们顺便来学一下Service节点下的属性吧。通常它长这个样子。

```xml
<service android:name=".service.ServiceTest"
            android:process=":remote" //不写remote，就不会跨进程。 不写冒号，进程名就叫emote，容易分不清
            android:exported="true">
            <intent-filter>
                <action android:name="com.android.aidl.action.MY_REMOTE_SERVICE"/>
            </intent-filter>
</service>
```
这里仅仅说的是 service节点下的，属性
**android:process** : 是否于单独的进程中进行，当设置为 android:process=":remote"时，代表Service在单独的进程中进行。 这里面的":"很重要，不加的话，进程的名字就不带包名。也有另外一种说法： android:process=":remote"，代表在应用
  程序里，当需要该service时，会自动创建新的进程，意思就是说你配的service会在另外一个进程中运行，而如果是
android:process="remote"，没有“:”分号的，则创建全局进程，不同的应用程序共享该进程。<font color=blue>我碰到了一个安装不上服务的问题。原因是我的process名字起的跟别的应用的里面的某个服务名字重复了，改了之后就能够安装上了！说明一个手机中是不能存在两个process名字相同的service的！</font>

**android:exported** : 代表是否能被其他应用隐式调用，是否允许外接访问。其默认值是service中有误intent-filter决定，如果有，默认值为true，否则为false。但是如果用户强制声明此值为false了，那么久意味着外部不可能通过隐式调用了。

**android:name** 对应的Service类名

**android:isolatedProcess** ：设置 true 意味着，服务会在一个特殊的进程下运行，这个进程与系统其他进程分开且没有自己的权限。与其通信的唯一途径是通过服务的API(bind and start)。

**android:enabled**：是否可以被系统实例化，默认为 true因为父标签 也有 enable 属性，所以必须两个都为默认值 true 的情况下服务才会被激活，否则不会激活。

###小结总结

整个步骤
<font color=#B8860B font=blod>
aidl--> aidl实现--> service onBinder吐出--> ServiceConnection捞取。
</color>
