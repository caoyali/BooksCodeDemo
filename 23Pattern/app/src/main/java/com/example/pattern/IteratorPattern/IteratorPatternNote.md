# IteratorPattern
万万没想到，迭代器模式说的就是最最最平常用到的数组迭代！我之前还以为是啥高大上的东西呢。这个目前可以说是很熟了。但是我想其中包含的思想尽量了解一下吧。
顿悟思想啊！
## thinking
来来来，看看最最最普通的代码
首先想一个问题哈！为什么源码有时候放着好好的for each 语句不让你用，偏偏“南辕北辙”似的让你取主动获取一个迭代器，然后自己再进行循环访问呢？
```java
public synchronized void removeCallback(Listener listener){
        if (null == listener) {
            return;
        }
        Iterator<Listener> iterator = mCallbackList.iterator();
        while (iterator.hasNext()) {
            Listener tempListener = iterator.next();
            if (listener == tempListener) {
                iterator.remove();
            } else {
                continue;
            }
        }
    }
```

```java
public interface Iterator<E> {
    boolean hasNext();
    E next();
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
```
妈呀我快词穷了。想得出来愣是描述不出来。我就举个简单的例子吧！假设我自己实现一个数据容器，里面的元素实际上出于某种原因，第一个元素位置实则不在第0个， 第二个元素跟第一个元素查了两个索引， 第三个元素跟第二个元素差了10个索引， 第四个元素干脆就存到另外一个成员变量的某个参数里面去了， 第五个呵呵呵，你可以理解为我是按照非常有自己原则但是外人看来就是觉得我十分杂乱无章这种方式来存储数据的！那么问题来了，如果有人需要遍历你的数据，你如何确保人家能正确的遍历？ （看你那人神共愤的源码吗-_-||？）将工作量转嫁给别人，小心被拎出来祭天啊！
所以迭代器就出来了啊！就是我定一套谁都看得懂的接口，然后以符合自己容器数据存储特性的算法，将这些接口实现！我怎么算出来的你们不用care，反正到时候你们只要调用，我就能给出对的数据，这就够了！
这不就得了么！
其实这里面涉及了一个思想，就是，作者自己实现接口，以作为一个工具供客户程序员很方便理解使用。我们之前的接口其实缺少了这种为难自己造福他人的高尚品质啊！