#include <iostream>
using namespace std;
int main() {
    int chest = 42;
    int waist = 0x42; //16进制
    int inseam = 042; //八进制

    cout << "Monsieur cuts a striking figure! \n";
    cout << "chest = " << chest << " (42 in decimal)" << endl;
    cout << "waist = " << waist << " (0x42 in hex)" << endl;
    cout << "inseam = " << inseam << " (042 in octal)" << endl;

    cout << "下面按照真正的进制来打印相关进制对应的值！" << endl;
    cout << dec; //设置以十进制输出
    cout << "chest = " << chest << endl;
    cout << oct; //设置以八进制输出
    cout << "inseam = " << inseam << endl;
    cout << hex; //设置以16进制输出
    cout << "waist = " << waist << endl;
    return 0;
}