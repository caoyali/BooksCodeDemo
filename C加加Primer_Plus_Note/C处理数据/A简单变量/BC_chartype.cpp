#include <iostream>
using namespace std;
void moreCharType();

int main() 
{
    char ch;
    cout << "Enter a character: " << endl;
    cin >> ch;
    cout << "Hola! ";
    cout << "Thank you for the " << ch << " character. " << endl;

    moreCharType();
}

void moreCharType()
{
    char ch = 'M';
    int i = ch;
    cout << "The ASCII code for " << ch <<  " is" << i << endl;   //cout可以根据类型的不同，打印出来的东西不同。

    cout << "Add one for " << ch << " is " << i << endl;

    cout << "Add one to the character code:" << endl;
    ch = ch + 1;
    i = ch;
    cout << "The ASCII code for " << ch << " is " << i << endl;
    cout << "Displaying char ch using cout.put(ch): ";
    cout.put(ch);   //这个put 是个啥？
    // cout. 后面这个点是一个很重要的面向对象概念。 这个put成员函数是用来输出字符的，中间的“点”被称为成员运算符。 实际上我们上面用到的
    // << 这个运算符与 .put是同一个效果的！ 只不过底层将这种操作封装成了运算符。

    cout.put('!');
}