# 什么是动态
动态说白了，就是在运行时发生的，而不是编译时发生的。所以以后拟碰见什么动态啊啥的，尽量往这里靠就行了，比如java中的runtime。都是一样的概念。就是按照运行阶段划分的而已！

# 使用new动态创建结构
我们先回顾一下之前我们的结构都是怎么创建的
拿以前的例子截出片段我们看看
```c++
struct inflatable{
    char name[20];
    float volume;
    double price;
};

inflatable in1 = {"鸭鸭梨", 20.0, 100.0};
```
以上是我们对于结构直接起个内存名 （以后我会直接称呼为内存名，因为我觉得这样叫，理解的更加透彻！）。然后直接进行初始化的。
然后我们怎么用呢？
```C++
cout << "U have init in1! in1.name=" << in1.name << endl;
```
我们在访问的时候，是这样访问的，这样直接一个点就出来了!因为你这样点，实际上也是找的内存名第几个参数，大家都是内存名，都能搞得到的。

**但是如果我要用一个指针呢？怎么表示呢？即使我new出来了要怎么去用呢？** 在这里我们要参考书中的写法，实际上是很简单的
```C++
inflateble* p_inf1 = new inflateble; //这样就算是初始化了一个指针了，你给了类型，初始化之后，至少运行的时候，人家知道你内存的位置在哪里，并且多大都是知道的。
```
但是我们如何访问它的参数呢？就那个  name  price ？ 这里有个细节需要我们记住一下！ 就是 ，你用new初始化的，内存的第一个位置叫 p_inf1， 它存储的内容，是inflateble 的一个地址而已，但是  inflateble 的名字叫啥呢？？你是不是发现从始至终你都没有给过呀! 你连名字都没有办法拿到，靠直接点出来，是不合规的！！在C++的体系内知道是”它“无法理解的事情。 为了解决这种问题， C++提供了一个 **<font color=green>-></font>** 符号。这个符号就是我之前傻傻分不清的符号，我不知道用点，还是用这个，每次都很慌。C++就是借此来进行区分的！你是一块内存名，那么就用点，但是如果你是一个指针名，那么我捞不到内存名， 于是你就用 -> 这样我底层就自然会对这个做出相应的决策，最后让你算对！

但是我们依然还有另外一种写法， 我先提前说说最后给出例子！  *指针，，的意思不就是这块内存的内容么，它虽然不知道名字叫啥，反正你能通过这种方式直接访问内存呀？？？其实你也可以这样反向操作点出来！
所以访问数据是有两种方式的：

```C++
// 第一种方式
p_inf1 -> name;
// 第二种方式
(*p_inf1).name;   //都是可以的！
```

## 关于花式访问结构内容的例子
```C++
#include <iostream>
using namespace std;
int main()
{
    struct Inflatable{
        string name;
        float volume;
        float price;
    };

    Inflatable* in1 = new Inflatable;
    cout << "Please Enter name:" << endl;
    // cin.get(in1 -> name, 20); //这样写不行，但是书上就是这么写的。这个C++是特么怎么回事啊！
    cin >> in1 -> name;
    cout << "Please Enter volume" << endl;
    cin >> (*in1).volume;
    cout << "Please Enter price" << endl;
    cin >> in1->price;

    cout << "Name=" << in1 -> name << endl;
    cout << "Volume=" << (*in1).volume << endl;
    cout << "Price=" << in1 -> price << endl;

    delete in1;

    return 0;
}
```
![Snipaste_2022-04-07_12-51-48](/assets/Snipaste_2022-04-07_12-51-48.png)

# new与delete写一个输入字串的案例

```C++
#include <iostream>
char* getName();
int main()
{
    using namespace std;
    char* name1 = getName();
    cout << "name1=" << name1 << endl;
    cout << "name1's dess=" << (int*) name1 << endl;
    delete [] name1;
    delete [] name1; //这里会引发崩溃， 不能连续delete两次
    cout << "after delete name1's content=" << *name1 << endl;

    char* name2 = getName();
    cout << "name2=" << name2 << endl;
    cout << "name2's dess=" << (int*) name2 << endl;
    delete [] name2;
    return 0;
}

char* getName()
{
    using namespace std;
    cout << "Please enter a name: " << endl;
    char* name = new char[70];
    cin >> name;
    return name;
}
```
我的运行结果呀，跟想象的不是很一样，重点在于那个 delete 一个指针之后的打印，我的MAC打印出来的竟然是我输入的第一个字符， 但是我把代码粘贴到了一个网络上的执行器上打印的和书中的一模一样，我这里其实是比较奇怪的，难道MAC有另一个版本的C++？或者，我的编译器有点奇怪？？这个问题啊真的是有点奇怪啊。不过我暂且不追这个问题了，记住这块，兴许未来某一天，我可以很自然的找到这个答案。

# 自动存储，静态存储和动态存储

C++ 有三种管理内存的方式，
- 自动存储
- 静态存储
- 动态存储

## 自动存储
这个很简单，就是方法中临时声明的一些变量啥的，这个说白了就是栈存储这种角色。入栈出栈这种我们根本不用管。都是C++里面帮我们做好了的。所以这个又叫自动存储嘛。

## 静态存储
静态存储是整个程序执行期间都会存在的一种存储方式，使变量变成静态的有两种方式：一种是在函数外面去定义它，另外一种是在声明变量的时候加上static关键字。

## 动态存储
动态存储跟我们最近学到的知识点，也就是指针，这个知识点比较接近。new 和 delete关键字为我们提供了一种相较于自动存储和静态存储而言，更为灵活的存储方式。 他们管理了一个内存池，在C++里面称之为堆（heap）。 正因为这两个关键字的存在，我们可以在一个类里面去创建，另外一个类里面去销毁。是非常灵活的。但是正是因为过于灵活，对于程序员而言亏过于容易出现管理上面的问题。其中内存泄漏是一个存在比较广泛并且头疼的问题。new 与 delete给了程序员很强大的内存控制权。为此是需要付出代价的！