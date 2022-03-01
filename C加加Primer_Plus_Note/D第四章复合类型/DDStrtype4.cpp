#include<iostream>
#include<string>
#include<cstring>

int main() {
    using namespace std;

    char carry[20];
    string str;
    // 这行开始的时候有问题，是为什么呢？嗷嗷， 原因是我开始的时候定义的carry是int数组， 这个当然不行喽， 因为C++只会把char数组认为是字符串！ 一步一坑，这个坑是挺好的！
    cout << "The origin length of carry is: " << strlen(carry) << endl;
    cout << "The origin length of str is: " << str.size() << endl;

    //endl是啥意思来着？和 \n 的区别是什么呢？
    // endl 可以在程序继续执行之前保证刷新屏幕，但是 \n 却不会刷新屏幕。 如果你心疼刷新屏幕那点性能的话，那就不要用endl控制符了！
    cout << "Please input carry!" << endl;
    cin.getline(carry, sizeof carry / sizeof carry[0]);
    cout << "U have input carry with: " << carry << "\n";
    cout << "Please inpute str! \n";
     // str怎么输入来着？我忘了我靠！！！！！
    // cin.getline(str);
    getline(cin, str); // 对于C++送提供的 string 获取一行的方法是一个专门的方法
    cout << "U have input str with: " << str << "\n";

    cout << "The length of carry is : " << strlen(carry) << "\n";
    cout << "The length of str is : " << str.size() << "\n";



}