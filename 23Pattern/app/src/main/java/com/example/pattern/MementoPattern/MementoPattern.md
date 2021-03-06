# MementoPattern Pattern

#### 简述

备忘录模式通常用于解决用户回到操作的某个步骤这种问题。例如，一个简单的图片编辑器，用户一步步的处理某个图片，但是修着修着发现不对头，想要回退重新修。就不断的按撤销键。此时图片编辑器的内部状态是要一个个回退的，最终回退到用户最开始操作的某个步骤上。图片面板展示的样式也应该是回退之后的样子。这里面涉及到一个很重要的特点，就是“步骤！”。备忘录模式的关键也就在于对于步骤状态的存储。PS：对于回退，我记得之前也有一种模式也和回退有关。找了找，是命令模式。不过命令模式关注的是命令！是一种操作！而备忘录呢，关注的是状态和恢复状态。两者还是有稍许区别的。

#### 是碰到了什么问题，才出现的它

凡是涉及频繁回退，或者频繁要某个步骤的状态的问题，都应该考虑一下它。

#### 这个东西的具体是什么(详细的)

其实这个东西和命令模式，两个核心点都是同样的东西。就是他俩都关注了操作步骤，因为有一个个的步骤，才可以方便的回退，方便的返回退，方便的回到任意一个步骤。最最最重点的是，这种步骤是需要维护的，那就需要数据结构来进行维护。数据结构的加入，是这个模式的精髓。是一切涉及步骤回退类功能的精髓，至于这个结构中的元素存的到底是什么，得根据具体情况而定。

备忘录模式，就是给每一段的状态拍上一个快照类似的东西，然后将这些快照存储起来，如果用户恢复的时候，就拿出应该恢复的那个快照，再恢复出来。

假设有一个编辑器类，里面有一个字串，用于展示用户当前输入的文字。最开始想的是，如果我把这个编辑器类存储到数据结构中，到时候恢复的时候，直接拿出来，执行方法就可以了。这样是可以实现同样的功能。但是这样有很多点不好的地方。
- 万一，这个编辑器类十分庞大怎么办？数据存储起来岂不是很占资源？
- 万一这个编辑器持有很多存快照的时候根本不需要的引用怎么办？我存储这个，就相当于存了很多无关的东西。但是我根本就不需要这些个乱七八糟的东西呀。
- 通常编辑器类维护的数据，按照我们设计的原则而言，其成员变量一般是不可访问的。对于编辑器，其核心数据的重要性不言而喻。是万万不能随意提供给外部的，如果再把更改权限放开，更容易出问题。
- 万一这三个条件，你写的编辑器都占到了，肯定会有人吐槽的。这样不好。

综上所述，直接存编辑器类，太不靠谱了！那么我们就得另辟蹊径了。此时何不能根据编辑器类的某些恢复相关的成员变量生成一个相当清爽的衍生类呢？这个衍生类里面只存编辑器中某个成员变量在某个步骤中生成的那种状态。这个衍生类，就是备忘录模式的另一个重要成员--快照！这个快照的产生者，就是编辑器本身，因为毕竟最了解自己情况的出了编辑器本身，找不到第二个类了呀，只有编辑器知道最准确切最全最新鲜的状态数据。编辑器在存快照的时候，拿出自己最重要的状态，生成一个快照对象，并将最重要的状态统统赋值给快照对象，就可以了。

到现在，备忘录模式中的两个角色--快照产生者、快照。已经粉墨登场了，还剩下了一个角色需要讲一下。这个角色很简单，就是存储数据的那个家伙。我感觉这个太简单了，怎么实现这个数据结构根据相关的业务而定。但是最重要的就是要记住，这个里面的数据结构存储的就是上面刚讲的，快照！

```puml
@startuml
note bottom of Memento : 快照
class Memento{
    StringBuilder mStr (用于恢复的重要数据)
}

note top of Originator : 相当于编辑类
class Originator{
StringBuilder mStr;
void appendStr(String str)//编辑用
Mementor tackMementor(); //获取当前的快照
void restore(Memetor m); // 根据快照恢复快照中对应的状态
void toString();
}

note top of Caretaker : 快照存储类。并有可以吐出回退时应该有的快照
class Caretaker{
    void add(Mementor m);
    Mementor back(); //回退方法
}

Caretaker --> Memento : Caretaker存储了Memento
Originator <--> Memento : Originator 会生成 Memento对象
@enduml
```

下面有一个简单的例子。

```java
package com.example.pattern.MementoPattern.demo1;

class Originator {
    private StringBuilder mStr;

    public Originator() {
        this.mStr = new StringBuilder();
    }

    public void append(String s) {
        mStr.append(s);
    }

    public Memento takeMemento(){
        Memento memento = new Memento();
        memento.mStr = new StringBuilder(this.mStr.toString());
        return memento;
    }

    public void restore(Memento memento) {
        this.mStr = memento.mStr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"mStr\":")
                .append(mStr);
        sb.append('}');
        return sb.toString();
    }
}

```

```java
package com.example.pattern.MementoPattern.demo1;

import java.util.Stack;

class CareTaker {
    private Stack<Memento> task  = new Stack<>();
    public void add(Memento memento) {
        task.push(memento);
    }

    public Memento back() {
        return task.pop();
    }
}

```

```java
package com.example.pattern.MementoPattern.demo1;

class Memento {
    public StringBuilder mStr;
}

```

```java
package com.example.pattern.MementoPattern.demo1;

class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Originator originator = new Originator();
        originator.append("a");
        taker.add(originator.takeMemento());

        originator.append("yayali");
        taker.add(originator.takeMemento());

        originator.append("666666");
        taker.add(originator.takeMemento());

        originator.restore(taker.back());
        System.out.println(originator);

        originator.restore(taker.back());
        System.out.println(originator);

        originator.restore(taker.back());
        System.out.println(originator);
    }
}

```