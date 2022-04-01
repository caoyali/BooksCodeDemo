#include<iostream>
struct inflatable{
    char name[30];
    float voluem;
    double price;
};
int main() {
    inflatable inflatebles[2] = {
        {"黎明", 20.0, 150},
        {"小明", 12.0, 100}
    };
    using namespace std;
    // 看看这个令人头疼的写法啊！如果结构中有1000个变量，你也这样写？？太过分了吧！
    // 我甚至有些好奇这个语言设计时的历史环境了，这是得多简陋，才能设计成这么写？？？
    cout << inflatebles[0].name << ", " << inflatebles[0].voluem << ", " << inflatebles[0].price << endl;
    cout << inflatebles[1].name << ", " << inflatebles[1].voluem << ", " << inflatebles[1].price << endl;

    inflatebles[1] = inflatebles[0]; //结构是可以这样赋值的，重申一下，因为这点很常用！！！
    cout << inflatebles[1].name << ", " << inflatebles[1].voluem << ", " << inflatebles[1].price << endl;

    return 0;
}