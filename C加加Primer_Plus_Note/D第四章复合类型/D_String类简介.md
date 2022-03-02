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
  在C++新增string类之前，程序员也需要完成诸如给字符串赋值等工作。 对于C等个字符串，程序员使用C语言库中的函数来完成这些任务。 头文件cstring（以前为string.h）提供了这些函数， 拷贝字符串， 和追加字符串
  ```C++
  strcpy(str1, str2); // 将str2的内容拷贝到str1中，仅适用C语言中的用法
  strcat(str1, str2); // 将str2中的内容追加到str1的后面，仅适用C语言中的用法。我们项目老这样用，是不是他们根本没学C++？
  ```

  ```C++
  #include <iostream>
  #include <string>
  #include <cstring>
  using namespace std;
  int main()
  {
      char charr1[20];  //c语言老式写法
      char charr2[20] = "jaguar"; // C语言老式写法
      string str1;
      string str2 = "panther";

      str1 = str2;
      strcpy(charr1, charr2); // 老式写法只能对老式写法用？
      // strcpy(str1, str2);  好吧，果然是老式写法只能对老式写法。我勒个去！
      str1 += " paste";
      strcat(charr1, " juice"); //向后追加字符串

      int len1 = str1.size(); //c++ string写法
      int len2 = strlen(charr1); //C语言写法 

      cout << "The string " << str1 << " contains " << len1 << " characters" << endl;
      cout << "The string " << charr1 << " contains" << len2 << " characers" << endl; 
      return 0; 
  }
  ```
  ## string类IO

  下面的例子中，我自己写着写着不知道怎么输入 str 了， 我一度觉得自己白学了， 后来看看书发现，对于C++中的 string 怎么在控制台进行输入，就是本段落目的。 怪不得我觉得自己知道，但是实际上写不出来！原来是没有学过。但是仍然有一些细节需要注意一下。 就比如初始化carry之后不是立即打印了这个的内容长度了么？
  尽管我的电脑上打印的都是0， 但是可能由于执行机器的区别，导致实际上我的打印和书上的是不一致！
  ```C++
    #include<iostream>
  #include<string>
  #include<cstring>

  int main() {
      using namespace std;

      char carry[20];
      string str;
      // 这行开始的时候有问题，是为什么呢？嗷嗷， 原因是我开始的时候定义的carry是int数组， 这个当然不行喽， 因为C++只会把char数组认为是字符串！ 一步一坑，这个坑是挺好的！
      cout << "The origin length of carry is: " << strlen(carry) << endl;
      cout << "The origin length of str is: " << str.size() << endl;

      //endl是啥意思来着？和 \n 的区别是什么呢？
      // endl 可以在程序继续执行之前保证刷新屏幕，但是 \n 却不会刷新屏幕。 如果你心疼刷新屏幕那点性能的话，那就不要用endl控制符了！
      cout << "Please input carry!" << endl;
      cin.getline(carry, sizeof carry / sizeof carry[0]);
      cout << "U have input carry with: " << carry << "\n";
      cout << "Please inpute str! \n";
      // str怎么输入来着？我忘了我靠！！！！！
      // cin.getline(str);
      getline(cin, str); // 对于C++送提供的 string 获取一行的方法是一个专门的方法
      cout << "U have input str with: " << str << "\n";

      cout << "The length of carry is : " << strlen(carry) << "\n";
      cout << "The length of str is : " << str.size() << "\n";
   }
  ```
  ![Snipaste_2022-03-01_14-43-14](/assets/Snipaste_2022-03-01_14-43-14.png)

  但是书上的打印是：

  ![Snipaste_2022-03-01_14-44-45](/assets/Snipaste_2022-03-01_14-44-45.png)

那么对于这种问题的原因是什么呢？
- 初始化之前的char数组都是没有定义的，他里面的内容可以是内存上的任意内容！
- 函数strlen 内部的计算逻辑是以空字符为结束，进行计算，所以针对上一条来讲，我哪里知道到什么时候才能碰到空字符呢？说句实话其实是可以出现在任意地方的。 这就导致它计算出来的长度是任意的。<font color=red>我又想吐槽一句，C++真他妈垃圾！</font>

  ## 其他形式的字符串字面值

  额，，字符串竟然有字面量的概念，这个我是懵的！
  历史是这样的，我们之前不是讲过，C++里面还有一个叫wchar_t的类型么。尽管我自己在我的电脑上键入这些东西，但是我的电脑编译不过去！但是对于C++新增的 char16_t 和 char32_t, 我同样自己写代码的时候也是编译不过去，不知道为啥。但是我们之前已经讲了，如何声明char_t
  或者 char32_t呢？就是在前面加上小u或者大U：
  - u 代表char16_t
  - U 代表char32_t
  - L 代表wchar_t

以此类推，对于一个char数组类， wchar_t数组类，char16_t数组， char32_t数组来讲，其实我们是可以类推出来大致的初始化方式的。也就是，在字符串的前面加上 L u U诸如此类

```C++
wchar_t title[] = L"title";
char16_t str16[] = u"16161661";
char32_t str32[] = U"weyiyheviruwhivu";
```

### C++对于UTF-8编码格式字符串的支持
C++语法在之前加上 ```u8```的前缀，可以表示 utf-8 编码的字符串的字面量。字符可存储为 1-4个八位组。

### C++新增 raw 字符串表示原始字符串

1 什么是原始字符串呢？
我们键入一个 “\n” ， 会被认定为换行， 但是如果是原始字符串呢？就会认为它是一个 反斜线 和 一个 n， 后者就是原始字符串。那么怎么表示原始字符串呢？这个也是很简单的
 - 首先前面加一个前缀  R
 - 然后添加原始字符串的定界符。也就是用小括号括起来。

如下面例子所示：

```C++
R"(看看这个就是原始定界符！！！！\n \n \n \n 这几个会被打印出 \n 的， 而不是换行！！！！！)"
```

那么问题来了，原始定界符用到了小括号表示，那么原始字符中的小括号怎么表示呢？比如我要在屏幕中展示 （这就是原始字符串，你看看我的\n就没有换行吧！！！）

- 原始定界符和双引号之间，C++允许添加其他的字符的，可以以此确认一个更加严格的定界符， 我们在中间添加一个加号尾追一个星号！！！！记住了啊

```C++
R"+*((这就是原始字符串，你看看我的\n就没有换行吧))+*"
```

总结一下，就是加上  R"+*()+*"


