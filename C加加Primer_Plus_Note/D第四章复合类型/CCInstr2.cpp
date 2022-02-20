#include <iostream>
using namespace std;
int main() 
{
    const int size = 20;
    char name[size];
    char dessert[size];

    cout << "Enter your name : " << endl;
    cin.getline(name, size); //输入20个字符是不行的，因为这个得在后面加空字串，所以你得加19个字符！如果你强制
    // 写19个以上，那么他会截取前19个字符串，后面加空字符。但是那个空字符会不会涉及到下一个desser的值
    // 添加到队列里，这个真的不晓得了，至少我打印的都是 0

    cout << "Enter your faverate fold : " << endl;
    cin.getline(dessert, (sizeof dessert / sizeof dessert[0]));

    cout << "Hello " << name << " , i know your faverate fold is : " << dessert << endl; 
    for (int i = 0; i < size; i++)
    {
        int k = dessert[i];
        cout << "i is : " << k << endl;
        /* code */
    }
    return 0;
}