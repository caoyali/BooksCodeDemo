# 整型
C++ 提供了好几种整数类型。包括有符号类型，无符号类型。涵盖： char， short, int, long, 和C++新增的 long long。并且上述的所有类型都有有符号和无符号两种版本

但是由于计算机的要求不同，导致位数可能也会有所不同，下面介绍的时候只能确定一个最小的位数。
| 类型| 位数 | 有符号数 | 无符号数 |
| ---- | ---- | ---- | ---- |
|char|8|支持|支持|
|short|最少16|支持|支持|
|int|至少32|支持|支持|
|long|至少要比整数多|支持|支持|
|longlong| 至少64位，并且至少跟long一样长|支持|支持|
PS：能不能行啊，这么不确定！这块感觉好费解啊！

要知道系统中整数的最大长度，可以在程序中使用C++工具来检查类型的长度， 首先 sizeof运算符返回类型或者变量的长度，单位为字节。回去到的字节的值，依赖于系统的实现，正因如此，你可能会在A系统得到的int是4， 但是可能在其他的系统里面得到的是2， 这个是不确定的。这个工具主要是在climits文件中描述。

```c++
# include <iostream>
# include <climits>
using namespace std;
int main() {
    cout << "char is "<< sizeof(char) << " bytes" << endl;
    cout << "short is" << sizeof(short) << " bytes" << endl; 
    cout << "int is" << sizeof(int) << " bytes" << endl; 
    cout << "long is" << sizeof(long) << " bytes" << endl; 
    cout << "long long is" << sizeof(long long) << " bytes" << endl; 

    cout << "MAX Values:" << endl;
    cout << "char: " << CHAR_MAX << endl;
    cout << "short: " << SHRT_MAX << endl;
    cout << "int: " << INT_MAX << endl;
    cout << "long: " << LONG_MAX << endl;
    cout << "int: " << INT_MAX << endl;

}
```

## climis都有啥？

- 定义了一堆符号常量，这个文件实际上是由编译器厂商提供而来的，里面指出了其编译器中的值，在老系统中，这个值就是老系统的，在新的里面这个值就是新的。所以这个文件调用方法得到的东西是十分可信而且标准的！
- 仔细看这个文件里面的实现，有一堆的```# define xxxx```这类的代码。下面我们讲讲这个define指令

### define指令
define指令和include指令一样，同属于预处理编译指令！只不过这家伙的作用是进行全局替换。这个在使用上是我们定义常量用的。其实c++中有两种定义常量的方式，一种是用define， 另一种就是用户 const 关键字。 **其实C++建议用后者定义常量。 不过对于哪些必须提供给外接使用的头文件中，要是定义常量的话，就必须用 define这种方式去定义了。**

## 无符号类型
记住怎么写和最大值比有符号数打大一半就行了。
```
unsigned short change;
```

## 选择整型类型
int类型是对于计算机而言最自然的长度，也是计算机处理起来效率最高的长度。综上所述，能用int处理的数据，最好别用别的。 耽误效率。
short的话，可以节省一些内存。

## 字面量
字面量就是显示的书写常量。很简单。