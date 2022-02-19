# include <iostream>
int main() 
{
    using namespace std;
    char ch = 'M'; //以字面量的形式定义一个字符
    int i = ch;
    cout << "The ASCLL Code For " << ch << "is" << i << endl;
    cout << "Add Ont to charactor code:" << endl;
    ch ++;
    i = ch;
    cout << "The ASCLL Code For " << ch << "is" << i << endl;

    cout << "Display char use cout.put(ch):" << endl;
    cout.put(ch);
    cout.put('!');


}