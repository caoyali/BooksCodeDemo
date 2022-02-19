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

    long a , b;
    cout << "输入一个整数a" << endl;
    cin >> a;
    cout << "输入一个整数b" << endl;
    cin >> b;

    cout << "a 与 b 取模的运算结果为：" << a % b << endl; //经过测试得知， 取模运算只是针对整数类型才可以
    //例如 int， long可以， double 和 float其实是不行的！
}