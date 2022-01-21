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
字面量就是显示的书写常量。很简单。但是字面量有进制之分这个要分清楚
 ### 进制
- 十进制： 就是按照我们平时的写法就行了
- 八进制： 前面加一个0
- 十六进制： 前面加一个 0x

这个和我们java十分相似！！！
```c++
#include <iostream>
using namespace std;
int main() {
    int chest = 42;
    int waist = 0x42; //16进制
    int inseam = 042; //八进制

    cout << "Monsieur cuts a striking figure! \n";
    cout << "chest = " << chest << " (42 in decimal)" << endl;
    cout << "waist = " << waist << " (0x42 in hex)" << endl;
    cout << "inseam = " << inseam << " (042 in octal)" << endl;

    cout << "下面按照真正的进制来打印相关进制对应的值！" << endl;
    cout << dec; //设置以十进制输出
    cout << "chest = " << chest << endl;
    cout << oct; //设置以八进制输出
    cout << "inseam = " << inseam << endl;
    cout << hex; //设置以16进制输出
    cout << "waist = " << waist << endl;
    return 0;
}
```

### 单纯打印字面量的话，C++如何知道这个家伙使用的内存空间？
答： 后缀；
引：
```c++
cout << "现在是：" << 2022 << "年" << endl;
```
就像上面的一句话，C++怎么知道2022是个啥类型啊？
一般的话，如果不加后缀的话， C++默认这家伙是一个整数。如果想转成其他的，你可以专门加后缀
|l 或者 L| u 或者 U | LL | 等等 |
| ---- | ---- | ---- | ---- |
| long类型| 专指无符号数， 这个是与其他进行搭配使用的 | long long | - |

另外还有个我压根就不想学的冷知识，就是 无符号数你不加后缀的话，按照范围可以给你推测一个合适的长度，但是，有个隐藏的细节是，这个进制也有影响，我已经弃疗了，不想看这块了。

# Char类型：字符和小整数
char经常被用来处理字符，但是它也可以作为比short更小的整型来使用。
但是实际上，char是专为转储字符而设计的！我们的文字总共也就那几个字母和一堆符号，这些加起来都不会超过128个字符的， 因此一个字节就可以表示所有的符号。
综上所述char呢有两个用处
- 表示字符
- 表示比short还要省内存的整数。

## cin cout 对于char的兼容
char的本质，是一个占用内存比较少的整型。 但是，cin cout 却对这种类型的打印做了很好的兼容！
例如你输入一个 77 的char整型，最终打印出来的就是大写的M

## char的字面值定义
用单引号括起来就是
```char a = 'M';```

```c++
# include <iostream>
int main() 
{
    using namespace std;
    char ch = 'M'; //以字面量的形式定义一个字符
    int i = ch;
    cout << "The ASCLL Code For " << ch << "is" << i << endl;
    cout << "Add Ont to charactor code:" << endl;
    ch ++;
    i = ch;
    cout << "The ASCLL Code For " << ch << "is" << i << endl;

    cout << "Display char use cout.put(ch):" << endl;
    cout.put(ch);
    cout.put('!');


}
```

## char是有符号数还是无符号数？
char在默认情况下，既可能是有符号数，也可能是无符号数。 这个完全取决于C++的实现。这样的话， 开发人员可以最大程度的与硬件属性匹配起来。 如果char有某种使用对你很重要的话，你可以显式声明它到底是有符号数还是无符号数。
比如你想在一个char上存储200， 这时候，你用char唯一的办法就是将他显式声明为unsigned  这样的话，这个char的范围就会很大了。

## wcha_t 类型 （宽字符类型）
这个的确是我之前不了解的一种类型哈,虽然一个char， 8位足以表示我们所有的ASCLL码上的内容， 表示英文系统的文字啥的是没有什么问题的。 但是事实上世界上存在不同的语言系统， 8位有时候不够用！对于这种情况， C++有两种处理方式，我对这里有些好奇。。。
 - 如果大型字符集实现的是基本字符集，则编译厂商可以将char定义为一个16位的字节或者更长的字节！很直接哈，也就是直接将char的位数为扩大了。6啊！
 - char仍然是8位，但是多出一个wchar_t类型，以支持这种更大的字符集。

wchar_t类型是一种整数类型，它具有足够的空间，可以表示系统使用的最大扩展字符集。这块我觉得真的好乱啊。

## cin cout对wchar_t类型的支持
这个数据类型啊，很是特殊。其实早期的iostream头文件压根就不会支持这家伙的发音，但是后来支持了， 但是调用的方法名不是cin cout 而是
```wcin wcout```

## C++ 新增类型： char16_t 和 char32_t
在上面的学习中。针对于每一种类型的字面量，其书写方式是有特殊要求的。 比如你写一个   1000L, 就会认为这个类型是一个Long类型的。对于刚才我们扩展的 wchar_t 或者是接下来将要学习的 char16_t 和 char32_t是同理的！写字面量的时候都有对应的符号。现在我们先说这些类型的起源，之后来一个比较全面的总结
起源：
随着编程人员日益熟悉Unicode,类型wchar_t也已不能满足需求。 C++11 之后新增了类型 chat16_t(16位)  和 char32_t(32位)， 前缀u表示16位的那个， U表示32位， 为什么是前缀啊啊啊啊啊啊！
<font color=red>呵呵呵， 刚刚我写代码试了试，书上的例子，根本就编译不过啊我勒个去！</font>

# 扩展字面量与类型
|类型|字面量修饰|举例|
| ---- | ---- | ---- |
|char|-|-|
|short|-|-|
|int|-|-|
|float|f|1.0f|
|double|
|long|
|long long|

# bool类型
只记住一个就可以，就是 c++将非零值解释为true， 将0解释为false。其余的艮java一样