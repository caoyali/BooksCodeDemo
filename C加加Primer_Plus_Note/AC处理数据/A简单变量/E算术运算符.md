# C++ 算数运算符
算术运算符从简单的来讲大概有五种， 加减乘除 取模。 并且这些运算符都是 二元运算符。这里我觉得加减乘除什么的都是小儿科了， 我们稍微看一下取模运算符。

## 加减乘除
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

## 运算符的优先级和结合性
运算符的优先级与我们学的代数优先级是一致的， 如果想打破这种优先级，那么就用括号括起来！
优先级按照我们的代数优先级
结合性是从左到右来， 那么这里的结合性是什么意思呢？？假设运算公式里面同时出现了乘除， 并且乘除的操作数有一个是一样的， 例如 3 * 5 / 5, 乘除这两个优先级实际上是一样的， 那么这种情况下，就按照从左到右的规则，先算左边再算右边， 算完一项结合。


## 除法分支
为什么要专门讲除法我勒个天。
除法计算出来的结果类型取决于操作数的类型， 例如如果两个整数相除， 得到的结果现实中即使是小数， 但是计算机计算出来的也会取整， 除非两个操作数中其中一个是小数， 这样得到的结果可能会精确一些。

```c++
#include <iostream>
using namespace std;
int main() {
    //我疑惑的是 cout用点， 后面的用双冒号， 这俩到底是什么区别去
    cout.setf(ios_base::fixed, ios_base::floatfield);
    cout << "5 / 9 = " << 5 / 9 << endl;
    cout << "9.0 / 5.0 = " << 9.0 / 5.0 << endl;
    cout << "9.0 / 5 = " << 9.0 / 5 << endl;
    cout << "1e7 / 9.0 = " << 1e7 / 9.0 << endl;
    cout << "1e7f / 9.0 = " << 1e7f / 9.0 << endl;
    return 0;
}
```

![Snipaste_2022-02-08_08-02-23](/assets/Snipaste_2022-02-08_08-02-23.png)
## 求模运算符


```c++
#include <iostream>
int main() {
    using namespace std;
    const int Lbs_per_stn = 14;
    int lbs;

    cout << "Enter your weight in pounds:" << endl;
    cin >> lbs;
    int stone = lbs / Lbs_per_stn;
    int pounds = lbs % Lbs_per_stn;
    cout << lbs << " pounds are " << stone << " stone, " << pounds << " pounds(s)";
    return 0;
}
``