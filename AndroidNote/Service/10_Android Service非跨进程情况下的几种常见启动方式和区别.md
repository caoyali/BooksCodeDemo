#分类
服务分类：
- 前台服务， 有一些通知用户的界面的服务是前台服务， 前台服务是必须要展示一个 Notification的，你基本可以把这个当指标了
- 后台服务， 跟前台服务相反，不提示的就是后台服务。
- 绑定服务

可以同时绑定和开启服务，二者不冲突

Service由于是个组件，它在其他的应用里甚至也可以开启的，但是如果你写服务的话，要求只有你的应用可以用的话， 可以在Manifest文件中专门制定一下，只用作当前的应用。都是可以的。

# Service的几个回调

## onStartCommand()
通过startService()调用过来，这个回调会被触发。但是如果你通过startService去开启这个服务， 那么这个服务是不会自动关停的，而且是后台无限期的执行，除非你主动调用stopService， 或者Service主动调用stopSelf()
### 多次调用同一个service的start方法会怎么样？
首先，service起的是同一个，连对象都是同一个，然后， 调用几次，就会出几次年onStartCommand()。 但是onCreate()只一次哈。
## onBind()
通过bindService()开启的服务会调用这个方法。这种启动方式的犀利之处，在我看来也是好用之处。因为如果用户通过bind的方式去启动service的时候， 需要一个ServiceConnection实例的，这个实例的回调需实现，从这个实例的回调是可以拿到service本尊的！这样的话，只要拿到句柄，基本就可以完成互通了。
## onCreate()
在onStartCommand 和 onBind之前就可以调用，但是只调用一次，也就是创建完成的时候调用。
## onDestroy()
销毁的时候调用。
