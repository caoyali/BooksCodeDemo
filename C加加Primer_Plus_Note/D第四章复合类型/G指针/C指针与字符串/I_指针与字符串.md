# 指针与字符串

## cout 语句对于字符串的真正处理

cout的时候，其实它只认的是字符串第一个位置的地址，找到地址依次往后度，直到遇到空字符为止。 这也就意味着，你的字串无论是以下哪种写法，其实都是一样的处理方式，也就是人家只记第一个位置而已。之后往后读
- ```c++char chars[100] = "aaaaaaaaa";```
- ```c++ cout << "12343489578948594" << endl;  //实际上拿到的是 1 的地址，之后往后读而已```
- 上述的  chars 实际上不是一个数组名，而是一个地址！也就是指向第一个字符的地址。

```C++
# include <iostream>
# include <cstring>
int main() {
    char animal[20] = "bear"; // 细节！ “bear” 整一个都是地址！他就是一个地址，但是它的名字就是“bear”。 这里的细节是， 你吧一个存储 bear字串内容的地址，赋给了一个叫 animal 的char数组！但是事实上，这个animal也是一个地址！
    const char* bird = "wren";
    char* ps;

    using namespace std;
    cout << animal << " and " << bird << endl;
    cout << "Please enter a kind of animal!" << endl;
    cin >> animal;

    ps = animal; // 注意这里，animal在我们之前的话，是认为这个只是一个字符串数组的名字！但是事实上它是这个字符串数组的地址，第一个字符的地址！所以这里是可以赋值的！
    cout << "ps=" << ps << endl;
    cout << "Before use strcy(): \n"; 
    cout << animal << " at " << (int*) animal << endl;  //强制改成一个int的原因是，让cout读的时候按照int读！ 这样的话后面就不会解释成一个字串了！打印的就是地址！
    cout << ps << " at " << (int*) ps << endl; //指针如果存在强制转型的话也是允许的！实际上在理解上也是可以理解的通的！看运行时怎么解释就是，只不过解释的不对是你自己要承担的！
    ps = new char[strlen(animal) + 1];

    strcpy(ps, animal);
    cout << "After use strcpy! " << endl;
    cout << animal << " at " << (int*) animal << endl;
    cout << ps << " at " << (int*) ps << endl;

    delete [] ps; //我靠！！！！这里特别容易出现问题啊，写一个这样的代码还得回头捋代码， 往回看这个 ps 是个啥指针我靠！
    // 所以到底有没有纯char的指针？？我感觉。这样写， 就默认没有纯char了，万一后面就是一个空字符的话，就是相当于字符串，而这种并不是我希望的！

    return 0;
}

```

![Snipaste_2022-04-01_21-51-57](/assets/Snipaste_2022-04-01_21-51-57.png)


## cin to 一个指针的坑

我们看看以下的问题代码，我首先说它就是个问题代码了哈。我说它有问题就一定是有问题的，这个代码很简单，我们看看：
```C++
char* cinChar;
cin >> cinchar;
const char* constCinChar[100] = new char;
cin >> constCinChar;
```
对，就是这么简单，但是存在一些比较严重的问题，其实原因也很容易理解，在这里我不想解释原因了，只想把问题总结完而已。

- 不要 cin 一个常量指针
- 不要 cin 一个根本没有被初始化过的指针。因为它可能是任意一个位置!其影响我们之前早就提到过！