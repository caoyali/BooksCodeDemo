# C++ 算数运算符
算术运算符从简单的来讲大概有五种， 加减乘除 取模。 并且这些运算符都是 二元运算符。这里我觉得加减乘除什么的都是小儿科了， 我们稍微看一下取模运算符。

```c++
#include <iostream>
using namespace std;
int main() {
    float hats, heads;
    cout.setf(ios_base::fixed, ios_base::floatfield); //双冒号是啥意思
    cout << "Enter a number: ";
    cin >> hats;
    cout << "Enter nother number: ";
    cin >> heads;

    cout << "hats=" << hats << "; heads=" << heads << endl;
    cout << "hats + heads = " << hats + heads << endl;
    cout << "hats - heads = " << hats - heads << endl;
    cout << "hats * heads = " << hats * heads << endl;
    cout << "hats / heads = " << hats / heads << endl;
    // cout << "hats % heads = " << (hats % heads << endl;  // 难道取模只是针对整数？？？
}
```
<font color=red>但是就在我刚才写例子的时候碰见了一个有些头疼的问题， 就是 float ， a = 11.17 b = 50.25  加起来竟然展示的是 61.419998 , 但是在现实中的话应该是61.42才对。</font>
![Snipaste_2022-02-07_21-48-16](/assets/Snipaste_2022-02-07_21-48-16.png)
可是事实上明明是 61.42 为什么成了  61.419998？？书上说是float类型表示的有效位能力是有限的。但是我依然不理解凭什么就给削成这样了？？？
