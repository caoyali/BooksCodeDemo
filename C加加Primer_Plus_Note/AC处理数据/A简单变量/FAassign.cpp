#include<iostream>
using namespace std;
int main()
{
    cout.setf(ios_base::fixed, ios_base::floatfield);
    float three = 3;
    int guess(3.9832); // 竟然有这种初始化方式啊啊啊啊！！！！！
    int debt = 7.2E12;
    cout << "three = " << three << endl;
    cout << "guess = " << guess << endl;
    cout << "debt = " << debt << endl;
    return 0;
}
