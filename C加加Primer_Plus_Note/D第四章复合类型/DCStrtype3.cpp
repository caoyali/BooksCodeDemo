#include <iostream>
#include <string>
#include <cstring>
using namespace std;
int main()
{
    char charr1[20];  //c语言老式写法
    char charr2[20] = "jaguar"; // C语言老式写法
    string str1;
    string str2 = "panther";

    str1 = str2;
    strcpy(charr1, charr2); // 老式写法只能对老式写法用？
    // strcpy(str1, str2);  好吧，果然是老式写法只能对老式写法。我勒个去！
    str1 += " paste";
    strcat(charr1, " juice");

    int len1 = str1.size(); //c++ string写法
    int len2 = strlen(charr1); //C语言写法 

    cout << "The string " << str1 << " contains " << len1 << " characters" << endl;
    cout << "The string " << charr1 << " contains" << len2 << " characers" << endl; 
    return 0;
}