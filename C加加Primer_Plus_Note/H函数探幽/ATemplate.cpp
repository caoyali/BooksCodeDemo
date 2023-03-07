/**
 * 写一个简单的函数模板
*/

# include <iostream>

using namespace std;

// 普通模板
// 函数原型，是要加上template <typename T>的
template <typename T>
void swap1(T &, T &);

int main() {
    double aDouble = 100;
    double bDouble = 200;
    swap1(aDouble, bDouble);
    cout << "aDouble=" << aDouble << " bDouble=" << bDouble << endl;

    int aInt = 1;
    int bInt = 2;
    swap1(aInt, bInt);
    cout << "aInt=" << aInt << "bInt="  << bInt << endl;
    return 0;
}

// 在定义的时候，一定还是要加上前面这个template <typename T>语句的。
template <typename T>
void swap1(T& a, T& b){
    T temp = a;
    a = b;
    b = temp;
}

