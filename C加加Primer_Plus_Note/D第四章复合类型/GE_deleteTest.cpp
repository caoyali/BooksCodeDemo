#include<iostream>
int main() {
    int a = 15;
    int* p_int = &a;

    using namespace std;
    cout << "a's addr=" << &a << endl;
    cout << "---------------not new -----------------------" << endl;
    cout << "p_int = " << p_int << "And p_int's content=" << *p_int << endl;

    int* p_bint = new int;
    *p_bint = a;
    cout << "---------------new -----------------------"<< endl;
    cout << "p_bint=" << p_bint << " and p_bint's content=" << *p_bint << endl;
    cout << "---------------delete p_bint----------------------"<< endl;
    // 尽管我已经释放了但是打印出来的结果依然跟没有释放前似的，一切都是正常的，我感觉有点奇怪这里！！！！
    delete p_bint;
    cout << "after delete p_bint, p_bint=" << p_bint << endl;
    cout << "after delete p_bint, *p_bint=" << *p_bint << endl;
    *p_bint = 250;
    cout << "after delete p_bint, *p_bint=" << *p_bint << endl;

    cout << "---------------new int array-----------------------"<< endl;
    int* p_cArray = new int[3];
    *p_cArray = 1;
    *(p_cArray + 1) = 2;
    *(p_cArray + 2) = 3;

    p_cArray[0] = -1;
    p_cArray[1] = -2;
    p_cArray[2] = -3; //这样用也是可以的，这是指针在数组上做的一个比较简单的语法优化。
    cout << "p_cArray=" << p_cArray << " p_cArray's content=" << *p_cArray << endl;
    return 0;
}