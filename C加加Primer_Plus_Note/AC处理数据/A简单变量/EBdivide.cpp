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