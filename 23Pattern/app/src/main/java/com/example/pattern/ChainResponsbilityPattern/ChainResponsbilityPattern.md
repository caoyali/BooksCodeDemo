# 责任链模式
责任链模式其实是很简单的，起码比享元模式简单的多。

#### 问题的提出
网上有个特别普遍的例子，就是公司员工请假这个事儿。3天之内，直属上司可以批准，3天到5天，上司的上司批，如果是5天以上，直接CEO批。然后让你写代码，巴拉巴拉的。听到这个其实我想脑子中已经有一半的代码成品了吧。并且我已经在demo中写了一个最直接的例子。

#### 代码
```java
package com.example.pattern.ChainResponsbilityPattern.demo1;
/**
基类，留了一个处理接口。接收到参数的时候就处理。
*/
abstract class BaseChainHandler {
    protected BaseChainHandler next;

    public BaseChainHandler(BaseChainHandler next) {
        this.next = next;
    }

    abstract void handle(int days);
}
```

```java
package com.example.pattern.ChainResponsbilityPattern.demo1;

class BanZhuRenHandler extends BaseChainHandler{
    public BanZhuRenHandler(BaseChainHandler next) {
        super(next);
    }

    @Override
    void handle(int days) {
        if (days <= 3) {
            System.out.println("班主任批假！");
        } else {
            if (null != next) {
                next.handle(days);
            } else {
                System.out.println("班主任找不到更高权限的人了！！终止！");
            }
        }
    }
}
```

```java
package com.example.pattern.ChainResponsbilityPattern.demo1;

class JiBuZhuRenHandler extends BaseChainHandler{
    public JiBuZhuRenHandler(BaseChainHandler next) {
        super(next);
    }

    @Override
    void handle(int days) {
        if (days < 5) {
            System.out.println("级部主任批假！");
        } else {
            if (null != next) {
                next.handle(days);
            } else {
                System.out.println("级部主任找不到更高权限的人了！ 终止！");
            }
        }
    }
}
```

```java
package com.example.pattern.ChainResponsbilityPattern.demo1;

class XiaoZhangHandle extends BaseChainHandler{
    public XiaoZhangHandle(BaseChainHandler next) {
        super(next);
    }

    @Override
    void handle(int days) {
        System.out.println("校长批假！终止！");
    }
}

```

```java
package com.example.pattern.ChainResponsbilityPattern.demo1;

class Demo {
    public static void main(String[] args) {
        /** 责任链模式的 整条链路建设，是且必须是在外部创建的。
        * 我对这个做了比较深入的思考。得出了这个结论。
        * 原因是，责任链上的每一个节点，基本要做到只处理自己责任内的事情，责任外的不要插手！
        * 越插手以后越乱。
        * (我想象的场景是，一个业务节点处理一个工作的时候，如果他采用了更多的判断分支，
        * 存储了不同的next节点，根据业务来判断用哪一个next节点去处理， 之所以乱，
        * 是因为，这类判断逻辑，根本就不在节点的责任之内，他硬是处理实则是越权了。
        * 有一次越权，之后的维护只会出现更多次！很有风险的！)。要我的话，就是能没有就没有.
        * 所以，责任链的整条链路建造，必须要在一个更加上层的层面上进行建造。要将判断逻辑
        * 的压力转接到这个”上层管理器内“,哪怕写的再抽象，也得这样解耦。
        */
        BaseChainHandler xiaozhang = new XiaoZhangHandle(null);
        BaseChainHandler jibuZhuRen = new JiBuZhuRenHandler(xiaozhang);
        BaseChainHandler banzhuren = new BanZhuRenHandler(jibuZhuRen);
        /**
        * 其实按照面向对象来讲的话，学生可以直接联系的就是他的老师。所以此时用 banzhuren 
        * 去处理。 班主任处理不了，自己就会拿出next去处理。
        */
        banzhuren.handle(4);
    }
}

```
#### 核心
是处理类持有一个同类的对象作为成员变量。如果自己处理不了，就直接调用下一级的处理。其实核心就是，处理器要形成一个”链“。注意一定要是链！要是不是链，在我的概念里面，就不能称之为责任链模式！一定要是链，而不是树！我之前想过这个问题。如果是树的话，我们可能会在某个节点(因为树嘛！其下可能有不止一个next节点的，这种结构，总要涉及到一些检举逻辑，偏业务了！除非哈，这种处理已经成了一个模板，你才可以弄成树的结构， 比如android界面的触摸事件，点击，时树的结构，但这些处理是模板化处理的，与业务毫无关系！你才敢这样玩！)加入过多的业务逻辑判断，这些判断很可能涉及的业务超过了当前处理器节点的管理范围！会引发”越权管理！“

#### 拓展
有时间看看 RXJava的实现， 和 Android view中用到的相关思想。