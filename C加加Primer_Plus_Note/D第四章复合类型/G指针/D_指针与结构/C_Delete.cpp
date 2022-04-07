#include <iostream>
char* getName();
int main()
{
    using namespace std;
    char* name1 = getName();
    cout << "name1=" << name1 << endl;
    cout << "name1's dres=" << (int*) name1 << endl;
    delete [] name1;
    // delete [] name1; //这里会引发崩溃， 不能连续delete两次
    cout << "after delete name1's content=" << *name1 << endl;

    char* name2 = getName();
    cout << "name2=" << name2 << endl;
    cout << "name2's dres=" << (int*) name2 << endl;
    delete [] name2;
    return 0;
}

char* getName()
{
    using namespace std;
    cout << "Please enter a name: " << endl;
    char* name = new char[70];
    cin >> name;
    return name;
}