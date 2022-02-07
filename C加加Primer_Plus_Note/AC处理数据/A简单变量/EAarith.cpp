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
}