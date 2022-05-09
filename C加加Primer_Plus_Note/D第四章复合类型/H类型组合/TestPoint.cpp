#include<iostream>
// 举例证明，任何值，如果写的时候不加任何的符号！ 那么指的就是这个内存名里面存储的值！只因为指针里面存储的是一个地址，所以它里面的内容看起来不是100。
int main(){
    int a = 100;
    int *b = &a;

    using namespace std;
    cout << "a's value : " << a << endl;
    cout << "b's value : " << b << endl;
    cout << "b's content : " << *b << endl;

    cout << "b's addr is : " << &b << endl;
    cout << "b's addr content : " << *&b << endl;
}