#include<iostream>
int main() {
    using namespace std;
    int nights = 1001;
    int* pt = new int;
    *pt = 1001;

    cout << "nights value is:" << nights << " nights addr is: " << &nights << endl;
    cout << "pt content value is:" << *pt << " pt is: " << pt << endl;

    double* pd = new double;
    *pd = 1000001.1;

    cout << "size of pt: " << sizeof(pt) << endl;
    cout << "size of *pt: " << sizeof(*pt) << endl;
    cout << "size of pd: " << sizeof(pd) << endl;
    cout << "size of *pd: " << sizeof(*pd) << endl;

    return 0;
}