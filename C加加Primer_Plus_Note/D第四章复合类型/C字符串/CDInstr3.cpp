#include<iostream>
using namespace std;
int main()
{
    const int size = 20;
    char name[size];
    char dessert[size];

    cout << "Please Enter Your name!" << endl;  //故意输入过长的参数照样会出问题的。
    cin.get(name, size).get();

    cout << "Please enter your faverate fold!" << endl;
    cin.get(dessert, size).get();

    cout << "Your name is: " << name << "And your faverate fold is: " << dessert << endl;

    return 0;
}