#include <iostream>
#include <cstring>
using namespace std;
int main()
{
    const int size = 15;
    char name[size];
    char name2[size] = "c++owboy";
    cout << "Howdy! I'm " << name2 << "What's your name? " << endl;
    cin >> name;

    cout << "Well, " << name << ", Your name has " << strlen(name) << " Letters and is stored" << endl;
    cout << "In array of " << sizeof name << " Bytes" << endl;
    cout << "Your initail is " << name[0] << ".\n";
    name2[3] = '\0'; //set to null charecter
    cout << "There are the first 3 characters of my name: ";
    cout << name2 << endl;
    cout << "name2's length is : " << strlen(name2);  //得到的是3， 原因是第三个之后被改成空字符了，这种计算算作结尾
    return 0;
}
