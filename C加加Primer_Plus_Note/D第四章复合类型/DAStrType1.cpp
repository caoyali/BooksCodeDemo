#include<iostream>
#include<string>
using namespace std;
int main()
{
    const int size = 20;
    char charri1[size];
    char charrr2[size] = "jaguar";
    string str1;
    string str2 = "panther";

    cout << "Enter a kind of feline!" << endl;;
    cin >> charri1;

    cout << "Enter a kind of feline: ";
    cin >> str1;
    cout << "Here are some felines: \n";
    cout << charri1 << " " << charrr2 << " " << str1 << " " << str2 << endl;
    cout << "The third letter in " << charrr2 << " is " << charrr2[2] << endl;
    cout << "The third letter in " << str2 << " is " << str2[2] << endl;   //这个也是可以直接查看第几个字符的！！！！我觉得这里挺好的！
    return 0;
}