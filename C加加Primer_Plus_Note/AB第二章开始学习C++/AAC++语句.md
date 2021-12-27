# 声明
```C++
#include <iostream>
int main
{
    using namespace std;
    int carrots;
    carrots = 25;
    cout << "I have";
    cout << carrots;
    cout << " carrots."
    cout << endl;

    carrots -= 1;
    cout << "Crunch, crunch, Now I have " << carrots << " carrots." << endl;
    return 0;
}
```
int carrots 就是声明语句，意思是告诉编译器，你需要多少内存，以及内存单元的名称。编译器看到后会帮你填充哪些复杂的内存申请语句。这个都不用我们去管。

声明其实也可以分类

- 定义声明，这种声明会导致编译器为变量分配内存空间。
- 引用声明，这个声明更为复杂，这些声明会命令计算机使用在其他地方定义的变量。

其他的我感觉都没有必要学习！

# 类
懂java，这个不看也可以