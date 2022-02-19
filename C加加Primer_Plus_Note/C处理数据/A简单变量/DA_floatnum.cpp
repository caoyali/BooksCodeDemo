# include <iostream>
// 1 std 是如何定义的，以至于我们写这么一行预处理语句就可以运行！
using namespace std;
//这行是太久没有写过方法了， 快忘记怎么写的了！
void printFloatNum();
int main() {
    printFloatNum();
    return 0;
}

void printFloatNum() {
    // 1 ios_base 是啥， 2 双冒号的意思我又忘记了
    cout.setf(ios_base :: fixed, ios_base::floatfield);
    float tub = 10.0 / 3.0;
    double mint = 10.0 / 3.0;
    const float millon = 1.0e6;

    cout << "tub = " << tub;
    cout << ", a million tubs = " << millon * tub;
    cout << ", \nand ten millon tubs = ";
    cout << 10 * millon * tub << endl;

    cout << "mint = " << mint << " and a millon mints = ";
    cout << millon * mint << endl;
}