# 字符串

头疼，关于字符串C语言竟然和C++有不同的方式我靠。

## C语言中的字符串
C语言的字符串实现机制是char数组， 并以最后一个内容为空格   也就是ASCLL码中的0， 为结尾。
```c++
char dog[4] = {'d', 'o', 'g', 'a'}; //C语言不会把这个当成string， 原因是没有结尾, 打印出 “doga后面跟其他东西”
char cat[4] = {'c', 'a', 't', '\0'}; //c语言会把这个当成string来处理。 打印出“cat”
```
C语言啊， 有很多子串处理的函数，实则是看最后一个数值是不是空格来确定结尾的。 包括C++中的cout函数都是看char中最后一个空格结尾的。 这就会导致一个稍微尴尬的问题， 就是打印dog的时候，可能因为找不到结尾，会继续读其内存后面的东西，直到碰到一个空格。这就会导致dog打印的内容比doga多了。

### C语言中char数组的另外一种便捷的初始化方式
```C
char bird[11] = "Mr . Cheeps"; //这样就能识别的
char fish[] = "Bubbles"; //这样也行的，跟我们之前讲的其实一个套路
```
但是一旦这样做，就意味着按照字符串处理啦，既然作为字符串处理的话，后面肯定会自动加上一个空格的，所以上面的**bird** 明敏初始化里就10个元素但是声明的时候就是11.要不会出问题哈。

### 关于 char shirt_size = 's'; 而不能写成 char shirt_size = "s"的本质原因！

本质原因是， 后面的将会按照char数组来处理，但是你声明的时候已经明确表示这家伙不是数组，所以这里是有很明显的矛盾的。所以这样行不通。 而不是简单的语法问题OK。后者表示的可不仅仅是s而是 s 加上空格，是两个元素！把两个元素赋值给一个非数组的char，当然会出现问题！

## 拼接字符串常量
有时候字符串会很长无法放到一行中去，C++是允许字符串拼接的，但是怎么拼接呢？请看下面的写法
```c++
cout "I'd give my right arm to be" " a great violinist.\n";
cout "I'd give my right arm to be a great violinist .\n";
cout "I‘d give my right arm"
" to be a great violinist.\n";
```

### 在数组中使用字符串

我现在没有看书哈， 但是以我之前看得书中讲的东西，难道在数组里面使用字符串要 一个个这样？？
```c++
char a[] = "Latter";
char b[][] = {}//这样也太尴尬了吧！哎？双数组怎么表示呢？这个问题挺有趣的哈， 就像套公式一样
```

```c++
#include <iostream>
#include <cstring>
using namespace std;
int main()
{
    const int size = 15;
    char name[size];
    char name2[size] = "c++owboy";
    cout << "Howdy! I'm " << name2 << "What's your name? " << endl;
    cin >> name;

    cout << "Well, " << name << ", Your name has " << strlen(name) << " Letters and is stored" << endl;
    cout << "In array of " << sizeof name << " Bytes" << endl;
    cout << "Your initail is " << name[0] << ".\n";
    name2[3] = '\0'; //set to null charecter   这个\0 和我们的空格可不是同一个ASCLL码，这里别搞混。 所以你敲空格的时候，依然会打印空格，但是你敲\0的时候就是另外一个事情了。这个细节希望记一下。
    cout << "There are the first 3 characters of my name: ";
    cout << name2 << endl;
    return 0;
}
```
![Snipaste_2022-02-20_14-43-36](/assets/Snipaste_2022-02-20_14-43-36.png)

strlen 指的是计算出有效子串的长度， 但是不会把空字符算作在内。其内部逻辑依然遵循以空字符作为字符串的结尾。所以最后如果**你用 strlen 函数计算字符串长度的话，得到的结果是 3**， 因为后面的字符已经被你用代码强制设置成了空字符！

### cin对于输入字符串的处理

首先看看下面的代码和以下的表象
```c++
#include <iostream>
int main() 
{
    using namespace std;
    const int size = 20;
    char name[size];
    char dessert[size];

    cout << "Enter your name:" << endl;
    cin >> name;
    cout << "Enter your favorite dessert:\n";
    cin >> dessert;
    cout << "I have some delicious " << dessert;
    cout << " Fot you, " << name << " .\n";
    return 0;
}
```

![Snipaste_2022-02-20_15-24-42](/assets/Snipaste_2022-02-20_15-24-42.png)

代码写完之后还没等我输入dessert这个参数的时候，就执行完了。我自己也是不太明白为啥的，从书里找找答案吧！

### cin处理输入子串的规则

首先cin是让用户输入一些文字用的， 那么这个怎么来判断用户已经将子串出入完了呢，用户自己可没有办法输入空字符的！所以cin采用了另外一种方式来判断子串的结尾， 就是 **空格，回车，制表符tab**, 然后cin以这种为节点，将你输入的字符串，遇到空格或者另外两个情况的时候，cin的内部实则把他们当成了你输入完了一个字符串来对待，并**自己在后面加上了空字符，以便于之后别的函数的正常处理**，之后把字符存入了一个**队列里**， 当你键入 Alistair Dreeb的时候， 实则队列里已经有了两个元素了，当碰到 ```c++ cin >> dessert;```这行代码的时候，cin发现队列里还有，就直接采用队列里的内容了，直接去执行！<font color=red> 真是服了！！ </font>所以你会发现 dessert打印出来的竟然是 “Dreeb”！

反正到这里我已经隐隐的感觉我们这样用cin肯定是有坑的， 我输入的子串过长会不会出问题？？我试试！

我刚试了一下，屏幕里打印出来了 abort字样，正常情况下应该是completed!我认为这里的确 是有问题的！！！真的太太太太low了！一点都不严谨啊我的天！！！

很多程序都依赖于字符串输入，因此有必要对该主题做进一步的讨论。我们必须使用cin比较高级的特性，这个会在17章进行介绍！

### 每次读取一行字符串输入
就像上面说的， 如果只读一个单词，按照空格制表符换行这类的进行判断这样太局限了， instream中提供了读取一行的方法，这个只看换行符。 并且有的方法可以无视后面的换行符，有的方法可以连后面的换行符也读入，这里还是比较实用的。

#### getline 读取一行但是丢弃换行符

```c++
#include <iostream>
using namespace std;
int main() 
{
    const int size = 20;
    char name[size];
    char dessert[size];

    cout << "Enter your name : " << endl;
    cin.getline(name, size); //输入20个字符是不行的，因为这个得在后面加空字串，所以你得加19个字符！如果你强制
    // 写19个以上，那么他会截取前19个字符串，后面加空字符。但是那个空字符会不会涉及到下一个desser的值
    // 添加到队列里，这个真的不晓得了，至少我打印的都是 0

    cout << "Enter your faverate fold : " << endl;
    cin.getline(dessert, (sizeof dessert / sizeof dessert[0]));

    cout << "Hello " << name << " , i know your faverate fold is : " << dessert << endl; 
    for (int i = 0; i < size; i++)
    {
        int k = dessert[i];
        cout << "i is : " << k << endl;
        /* code */
    }
    return 0;
}
```

getline函数有一个特点是，他会在读取指定字数的字符或者遇到换行符之后停止读取！所以你恶意输入超过20个字符的时候，会出现和上一个例子差不多的问题， 就是第二个子串读都不读，直接继续执行， 但是后面那个dessert没有赋值不知道为啥.我觉得是不是直接终止，后面给加了一个终止符号啊！

![Snipaste_2022-02-20_16-19-31](/assets/Snipaste_2022-02-20_16-19-31.png)

#### get 读取一行并保留换行符