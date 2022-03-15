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
person XiaoWang;

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
