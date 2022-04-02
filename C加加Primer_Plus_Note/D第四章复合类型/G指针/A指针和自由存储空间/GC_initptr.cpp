#include <iostream>
int main() {
    using namespace std;

    int higgens = 5;
    int* p_higgdns = &higgens;
    cout << "higgens=" << higgens << " higgens's addr=" << &higgens << endl;
    // &p_higgdns 这个是地址的地址， 这个有点饶了。我不想写这么绕的代码坑自己！
    cout << "p_higgdns=" << p_higgdns << " p_higgens's addr=" << &p_higgdns << " p_higgens's content=" << *p_higgdns << endl;
    return 0;
}