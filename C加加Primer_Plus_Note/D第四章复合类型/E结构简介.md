# 结构简介
这个其实没什么好说的，就像我们定义一个类，类里面有成员变量，甚至，它们只是一个bean。诸如这样的关系。但是我看了两页书依然有一些不是很明白的地方。稍后我会写出我的质疑！

## 定义一个结构的语法，以及如何使用
```C++
struct Test {
    int name[20];
    int price;
    int volume;
};

//使用的时候这样

//声明
struct Test test1; //C语言风格声明语法
Test test2; //C++语言声明风格。

//用的时候， 就像java的对象那样， 用"点儿" 去点出来就行了！
````
<font color=red>就这里我就不明白了， 对于结构来讲，到底有没有对象的概念啊！这个东西和对象是什么区别呢？我觉的不是对象那样，又不new怎么进行赋值？</font>

这个结构跟我认识的java用法相似但是，又不一样，我奇怪的是它用起来像对象那样用，但是它没有new就可以直接点出来，纳闷啊，反正我有些不适应。
```C++
// 一个结构的声明
struct person{
    char name[20];
    int old;
    char addr[100];
}

//用的时候分两种语法，我们只看C++风格语法吧， C语言语法老掉牙了不想敲
person LiMing;
person XiaoHong;
person XiaoWang; //这里根本就没有new， 但是可以直接调用，这点跟我之前学的东西有点不一样！

//然后重点是后面的点了，开始出现OOP风格了。
LiMing.name = "LiMing";
LiMing.old = 20;
LiMing.addr = "河南省濮阳市";

//  访问成员函数是从访问结构的变量这里演化出来的！！！！
```
// 但是直到这里，我也不知道结构这家伙有多有用，因为你的函数在哪里？？没有操作只有数据我是觉得有些怪怪的。

# 在程序中使用结构
```c++
#include <iostream>
struct inflatable{
    char name[20];
    float volume;
    double price;
};

int main() {
    using namespace std;
    inflatable guest = {
        "Caoyali quest",
        1.88,
        29.99
    };

    inflatable pal = {
        "Caoyali pal",
        3.12,
        32.99
    };

    cout << "U have init guest! guest.name=" << guest.name << endl;
    cout << "U have init pal! pal.name=" << pal.name << endl;

    cout << "bose guest anf pal have " << guest.price +pal.price  << " Prices!" << endl;
}
```

上面的例子中，直接否定了我的猜想，事情是这样的，最开始的时候我以为 guest和pal共用一块内存，我也不知道我为什么有这么个印象，但是写代码的时候，最后的打印，直接否定了这个猜测。我可怕这种不良的思路了，因为不知不觉自己学偏了就问你害不害怕。

## 其他结构属性
讲的主要是，你可以向使用其他变量一样使用结构，包括
- 将一个结构赋值给一个结构
- 在函数中，结构作为一个参数传给一个方法
- 在函数张，结构也可以作为返回值返回出去

是不是已经有开始有OOP那味了。

```C++
# include <iostream>
struct inflateble{
    char name[20];
    int volume;
    double price;![Snipaste_2022-03-16_11-45-14](/assets/Snipaste_2022-03-16_11-45-14.png)
};

int main() {
    inflateble bouquet = {
        "yayali",
        10,
        20.0
    };

    using namespace std;
    cout << "bouquet.name=" << bouquet.name << " bouquet.volume=" << bouquet.volume << " bouquet.price=" << bouquet.price << "\n";
    inflateble bouquet2;
    cout << "bouquet2.name=" << bouquet2.name << " bouquet2.volume=" << bouquet2.volume << " bouquet2.price=" << bouquet2.price << " \n";
    bouquet2 = bouquet;  //这句是重点， 结构是可以赋值的，就像用一个普通的变量那样用。
    cout << "赋皖智值后： bouquet2.name=" << bouquet2.name << " bouquet2.volume=" << bouquet2.volume << " bouquet2.price=" << bouquet2.price << " \n";
    return 0;
    // 但是有没有发现，结构就是结构，里面不能给你支持操作，操作也就是方法，或者函数，里面没有
}
```
![Snipaste_2022-03-16_11-45-14](/assets/Snipaste_2022-03-16_11-45-14_ddi85qmon.png)

## 结构的其他写法
<font color=red>对于C++而言，总是有什么第二种写法什么的，是最让我恼火的一点，因为要记得好多啊！而且有什么意义么？除了少敲几个字？还得记真的好烦人啊</font>

写这个例子的时候我挺痛苦的，因为稍微一自己发挥，语法就写错了，我真心不怎么喜欢这种语言！
[EB_assgn_st.cpp](EB_assgn_st.cpp)

## 结构数组

结构数组，我开始认为，作者只是简单的想说一下，结构里面支持数组。 但是事实上比我想的复杂那么一丢丢。 他的意思是，你的数组，里面的item也可以是结构！就这样而已。 就像下面：
```C++
Test tests[100];
```
至于怎么声明，这里我就十分奇怪了！
- 书里说的声明是，大括号中间加逗号，就像我接下来会写的例子那样。如此“简单”
- 但是说实话，你特么会这样写么，这他妈是什么垃圾玩意儿啊！又臭又长！
- 那么你想想，是不是又别的方法将这个初始化的优雅一些呢？？可以我试过了啊，声明和初始化分离来写，就特么报错！！！！除非你直接赋值啊老铁！！这还能怎么搞！我真的时时刻刻都想吐槽！

来来来，接下来感受一下这种令人头疼的写法。

```C++
#include<iostream>
struct inflatable{
    char name[30];
    float voluem;
    double price;
};
int main() {
    inflatable inflatebles[2] = {
        {"黎明", 20.0, 150},
        {"小明", 12.0, 100}
    };
    using namespace std;
    // 看看这个令人头疼的写法啊！如果结构中有1000个变量，你也这样写？？太过分了吧！
    // 我甚至有些好奇这个语言设计时的历史环境了，这是得多简陋，才能设计成这么写？？？
    cout << inflatebles[0].name << ", " << inflatebles[0].voluem << ", " << inflatebles[0].price << endl;
    cout << inflatebles[1].name << ", " << inflatebles[1].voluem << ", " << inflatebles[1].price << endl;

    inflatebles[1] = inflatebles[0]; //结构是可以这样赋值的，重申一下，因为这点很常用！！！
    cout << inflatebles[1].name << ", " << inflatebles[1].voluem << ", " << inflatebles[1].price << endl;

    return 0;
}
```

## 结构中的位字段

我竟然从头到尾不知道位字段这个东西我靠！我怀疑自己看了一本假书！
与C语言中一样，C++也支持占用特定位数的数据成员，这使得创建与某个硬件设备上的寄存器对应的数据结构非常方便。字段的类型应为**整型或者枚举**， 接下来是冒号，冒号后面是一个数字，它能指定使用了多少位数，可以使用没有名称的字段来提供间距。每个成员都被称为位字段。
```C++
struct torgle_register{
    unsignd int SN : 4;
    unsignd int : 4;
    bool goodIn : 1;
    bool goodTorgle : 1;
}
```
我觉得这块挺不重要的。所以嘿嘿嘿，意思意思就行了