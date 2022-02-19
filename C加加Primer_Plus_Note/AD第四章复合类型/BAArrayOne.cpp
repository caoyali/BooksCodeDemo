#include <iostream>
int main()
{
    using namespace std;

    int yams[3]; //的确和java语法不一样哈
    // 如果你的代码不进行初始化，那么它里面的元素在这一刹那可能是任意值。不确定的值。很危险的。
    yams[0] = 7;
    yams[1] = 8;
    yams[2] = 6;

    int yamcosts[3] = {20, 30, 5};  //一次性全部赋值，比yams赋值要来的方便
    cout << "Total yams = " << yams[0] + yams[1] + yams[2] << endl;
    cout << "The package with " << yams[1] << " yams costs " << yamcosts[1] << " cents per yam. \n" << endl;

    int total = yams[0] * yamcosts[0] + yams[1] * yamcosts[1] + yams[2] * yamcosts[2];
    cout << "The total yam expencse is " << total << " cents .\n";

    cout << "Size of yams is " << sizeof yams << endl;   //我靠这语法， 连括弧都不用的吗？？？？？
    cout << "Size of first element is " << sizeof yams[0] << endl;   //得到的是 4  4 是什么鬼我去？？？
    //划重点，sizeof之前书中讲过但是我忘了， 这个关键字得出的是其内容占用的长度， 所以yams长度是12， yams[0] 是4. 这个关键字可以用在很多value上用来看长度
    return 0;
}