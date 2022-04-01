# include <iostream>
int main() {
    double wages[3] = {10000.0, 20000.0, 30000.0};
    short stack[3] = {3, 2, 1};

    double* pw = wages;
    // short* ps = &stack; //为什么不能直接引用 &stack呢？这句语法不过！
    short* ps = &stack[0];

    using namespace std;
    cout << "pw=" << pw << " *pw=" << *pw << endl; // pw=一个地址， *pw = 10000.0

    pw = pw + 1; 
    cout << "Add 1 to pointer pw!" << endl;
    cout << "pw=" << pw << " *pw=" << *pw << endl; // pw=一个地址加或者减， *pw = 20000.0

    cout << "ps=" << pw << " *ps=" << *ps << endl; // ps=一个地址 *pw = 3
    ps = ps + 1;
    cout << "Add 1 to pointer ps!" << endl;
    cout << "ps=" << ps << " *ps=" << *ps << endl; // ps=一个地址加或者减 *ps = 2

    cout << "-----------------------------------" << endl;
    cout << "Access two elaments with array anotation!" << endl;
    cout << "stack[0]=" << stack[0] << " stack[1]=" << stack[1] << endl;  // 3， 2
    cout << "Access two elements with pointer anotation!" << endl;
    cout << "*stack=" << *stack << " *(stack + 1)=" << *(stack + 1) << endl; //3, 2
    cout << "sizeof(wages)=" << sizeof(wages) << endl;  // 整个数组的大小
    cout << "sizeof(*pw)=" << sizeof(pw) << endl;          //一个地址值所占用的位数

    cout << "pw[0]=" << cout << pw[0] << " pw[1]=" << pw[1] << endl; //这个pw是一个指针哈，但是不难看出，我们调用的语法仿佛它不是个指针似的！
    cout << "ps[0]=" << cout << ps[0] << " ps[1]=" << ps[1] << endl; //这个ps是一个指针哈，但是不难看出，我们调用的语法仿佛它不是个指针似的！

    return 0;
}