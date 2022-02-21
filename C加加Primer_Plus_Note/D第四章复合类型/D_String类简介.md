# String类简介

IOS/ANSI C++98标准通过添加string类扩展了c++库， 因此现在可以string类型的对象，而不是字符数组来存储字符串。string类使用起来比数组要简单的多，同时提供了将字符串作为一种数据类型的表示方法。
要使用string类，必须要在程序中包含其头文件， string类同样也位于命名空间中。 这里是不是想起了我们之前学的命名空间，这个命名空间可是会横跨很多类的，是java所没有的那种概念。string类隐藏了字符串数组的性质，因此能够让我们像处理普通变量那样去处理字符串。

```C++
#include<iostream>
#include<string>
using namespace std;
int main()
{
    const int size = 20;
    char charri1[size];
    char charrr2[size] = "jaguar";
    string str1;
    string str2 = "panther";

    cout << "Enter a kind of feline!" << endl;;
    cin >> charri1;

    cout << "Enter a kind of feline: ";
    cin >> str1;
    cout << "Here are some felines: \n";
    cout << charri1 << " " << charrr2 << " " << str1 << " " << str2 << endl;
    cout << "The third letter in " << charrr2 << " is " << charrr2[2] << endl;
    cout << "The third letter in " << str2 << " is " << str2[2] << endl;   //这个也是可以直接查看第几个字符的！！！！我觉得这里挺好的！
    return 0;
}
```
从上面的代码我们可以看出来，虽然string隐藏了数组的存在，但是事实上还是可以通过索引去访问每一个元素的。 那么他们的sizeOf呢？会不会像java一样一开始有个默认的容量， 等到不够的时候再去扩容呢？

string有哪些便捷的用法呢？
- 可以使用cin将键盘内容存储到string对象中去
- 可以使用C风格字符串来初始化string对象
  也就是```c++ string aaa = {"hahahahahahah hahahah"}``` 这样也是可以的
- 可以使用cout来显示string对象
- 可以使用数组来访问存储在string中的字符。
  
  ## 赋值， 拼接和附加
  对于数组而言，我们之前已经提到过，不能将一个数组赋值为另外一个数组，因为我们之前学的字符串也是一个char数组，所以不能把一个字符数组赋值给另外一个字符数组， 但是string就相对易用的多了，它可以做到一个string赋值给另外一个string的！
  并且string简化了字符串的合并操作，可以使用运算符+将两个string对象合并起来， 还可以使用+=号。这个其实和java没有太大的区别哈。
  
  ```c++
    #include <iostream>
    #include <string>
    int main()
    {
        using namespace std;
        string s1 = "penguin";
        string s2, s3;
        cout << "You can assign one string object to another: s2 = s1!" << endl;
        s2 = s1;
        cout << "s1:" << s1 << " s2:" << s2 << endl;
        cout << "You can assign a C-style string to another object." << endl;
        cout << "s2 = \"buzzard\"" << endl;
        s2 = "buzzard";
        cout << "s2:" << s2 << endl;
        cout << "You can append string" << endl;
        s1 += s2;
        cout << "s1 += s2 yield s1 = " << s1 << endl;
        s2 += " for a day";
        cout << "s2 += \" for a day\"" << " yields s2 = " << s2 << endl;
        return 0;
    }
  ```

  ## string类的其他操作
  在C++新增string类之前，程序员也需要完成诸如给字符串赋值等工作。 对于C等个字符串，程序员使用C语言库中的函数来完成这些任务。 头文件cstring（以前为string.h）提供了这些函数

  ## string类IO

  ## 其他形式的字符串字面值