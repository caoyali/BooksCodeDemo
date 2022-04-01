# 指针、数组和指针算数

## 指针算数
我们之前的章节里面已经学习过一个知识点，就是指针的用法， 其调用方式其实可以跟数组的变量名称那样去调用的。正如下面的例子，最后的几句话！
```c++
# include <iostream>
int main() {
    double wages[3] = {10000.0, 20000.0, 30000.0};
    short stack[3] = {3, 2, 1};

    double* pw = wages;
    // short* ps = &stack; //为什么不能直接引用 &stack呢？这句语法不过！
    short* ps = &stack[0];

    using namespace std;
    cout << "pw=" << pw << " *pw=" << *pw << endl; // pw=一个地址， *pw = 10000.0

    pw = pw + 1; 
    cout << "Add 1 to pointer pw!" << endl;
    cout << "pw=" << pw << " *pw=" << *pw << endl; // pw=一个地址加或者减， *pw = 20000.0

    cout << "ps=" << pw << " *ps=" << *ps << endl; // ps=一个地址 *pw = 3
    ps = ps + 1;
    cout << "Add 1 to pointer ps!" << endl;
    cout << "ps=" << ps << " *ps=" << *ps << endl; // ps=一个地址加或者减 *ps = 2

    cout << "-----------------------------------" << endl;
    cout << "Access two elaments with array anotation!" << endl;
    cout << "stack[0]=" << stack[0] << " stack[1]=" << stack[1] << endl;  // 3， 2
    cout << "Access two elements with pointer anotation!" << endl;
    cout << "*stack=" << *stack << " *(stack + 1)=" << *(stack + 1) << endl; //3, 2
    cout << "sizeof(wages)=" << sizeof(wages) << endl;  // 整个数组的大小
    cout << "sizeof(*pw)=" << sizeof(pw) << endl;          //一个地址值所占用的位数

    cout << "pw[0]=" << cout << pw[0] << " pw[1]=" << pw[1] << endl; //这个pw是一个指针哈，但是不难看出，我们调用的语法仿佛它不是个指针似的！
    cout << "ps[0]=" << cout << ps[0] << " ps[1]=" << ps[1] << endl; //这个ps是一个指针哈，但是不难看出，我们调用的语法仿佛它不是个指针似的！

    return 0;
}
```
从上面的例子中我们不难看出，对于指针的加减法，跟普通的一个基础变量的加减法貌似存在不一样的地方。 正如上面的代码里那样，对于指针 stack， 明明就加了个1， 但是打印出来的地址内容，的的确确是指针下一个元素的内容。但是照我们之前学的，理论上应该打印出来一个根本就没办法识别的内容才对，但是事实上的确打印的符合不了解的人的常识。 
指针在数组上的表现等同于数组内存命名本身调用的原因就得益于C++对于指针的运算支持， 当我们声明一个指针的时候，我们可是已经给了指针的类型的，那么这个意思就是，C++实际上是知道你的指针应该到哪个节点阶段去取指针附近的内容并接续出来!既然这样的话，我们是完全可以在这套信息的基础上做一些更加区域常识的解释工作。
其实C语言和C++的内部都是用指针去处理数组的。有了这套规则，你怎么调用都可以解释的很好的。

所以你以为
stack[0] = *(ps + 0)  是前面的这样写可以用后面的 写法代替， 但是实际上，人家C++在底层的实现，就是当你输入  stack[0], 人家处理成了 *(ps + 0)，，所以是因为有了这种处理你才可以用 ps[0] 啊， 或者 stack[0] 啊这种去搞定。。因果关系要搞清 *(ps + 0)是因， stack[0]是处理的果。所以你才能这样去写代码