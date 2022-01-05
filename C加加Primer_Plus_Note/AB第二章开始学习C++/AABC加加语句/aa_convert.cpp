# include <iostream>
int convert(int);
int main() 
{
    using namespace std;
    cout << "请输入斤数，我们将转换为千克";
    int i;
    cin >> i;
    cout << "您刚才输入的是" << i << "斤"; 
    i = convert(i);
    cout << "转换的结果是" << i << "千克"; 
}

int convert(int i) {
    return i * 2;
}