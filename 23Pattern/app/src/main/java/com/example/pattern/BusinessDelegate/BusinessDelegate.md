# Business dalegate pattern
我看网上的例子，以及描述，千篇一律，根本不知道到底再说了啥。就这种文章，难道除了我以外的所有人都能看得懂？

我认为，从网上看，全部都是一个结果，包括外网。不知道谁抄谁的，太水了！

如果实在不清楚，我们可以直接看看最终的模型是怎么调用的

```java
ServerDelegate serverDelegate = new ServerDelegate();
serverDelegete.setServerType("请求登录");

Client client = new Client();
client.setServerDelegate(serverDelegate);
client.rqeuest();   

// 这里比较重点的是，你看看切换的时候是怎么调用的，只需要把代理的type设置一下就可以了。这块对于用户。
serverDelegate.setServerType("请求首页列表")
client.request();
```
看到这种写法我不是很理解，因为一旦ServerDelegate是公用的，而且是大范围公用的话，我怕会出现多线程之类的问题。


