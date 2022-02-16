#include <iostream>
int main()
{
    using namespace std;
    int auks, bats, coots;
    auks = 19.99 + 11.99; // 31
    bats = (int) 19.99 + (int) 11.99; //C语言语法  30
    coots = int (19.99) + int (11.99); //C++语法， 我靠竟然能够这么写，这也太不靠谱了 30
    cout << "auks=" << auks << " bats="  << bats << " coots=" << coots << endl;

    char ch = 'Z';
    cout << "The code for " << ch << " is " << int (ch) << endl;
    cout << "Yes code is " << static_cast<int> (ch) << endl;
    return 0;
}