# State Pattern （状态模式）
在状态模式中，类的行为是基于他的状态改变的。这种类型的设计模式属于行为型模式。
在状态模式中，我们创建表示各种状态的对象，和一个行为随着状态对象改变而改变的context对象。
??? context不是上下文吗？怎么还有行为？
##### 介绍
**简介**


```java
public interface State{
    public void doAction(Context context);
}
```

```java
public class StartState implements State{
    public void doAction(Context context) {
        Systerm.out.println("Player is start state");
        context.setState(this);
    }

    public String toString() {
        return "Starte State";
    }
}
```

```java
public class StopState implements State{
    public void doAction(Context context) {
        Systerm.out.println("Player is stop");
        context.setState(this);
    }

    puclic String toString() {
        return "Stop State";
    }
}
```

```java
public class Context{
    private State state;
    public Context(){
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
```

```java
public class StatePatternDemo{
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction(context)

        StopState stopState = new StopState();
        stopState.doAction(context);    //做一些事情，并更新上下文的状态
    }
}
```

State应该是一个接口，context是持有这个接口对象的，那么久意味着，state的实现类都要实现统一的接口。同事，实现接口对Context有依赖关系，会在做操作的时候，最后设置上下文的状态。 反正以我的习惯是不会这样写的。

??? 问题来了， 为什么不让Context 做 doAction() 而是让State去做