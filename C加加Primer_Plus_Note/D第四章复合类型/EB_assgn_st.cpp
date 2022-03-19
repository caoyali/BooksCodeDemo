# include <iostream>
struct inflateble{
    char name[20];
    int volume;
    double price;
};
using namespace std;
int main() {
    inflateble bouquet = {
        "yayali",
        10,
        20.0
    };
    cout << "bouquet.name=" << bouquet.name << " bouquet.volume=" << bouquet.volume << " bouquet.price=" << bouquet.price << "\n";
    inflateble bouquet2;
    cout << "bouquet2.name=" << bouquet2.name << " bouquet2.volume=" << bouquet2.volume << " bouquet2.price=" << bouquet2.price << " \n";
    bouquet2 = bouquet;  //这句是重点， 结构是可以赋值的，就像用一个普通的变量那样用。
    cout << "赋皖智值后： bouquet2.name=" << bouquet2.name << " bouquet2.volume=" << bouquet2.volume << " bouquet2.price=" << bouquet2.price << " \n";
    // 但是有没有发现，结构就是结构，里面不能给你支持操作，操作也就是方法，或者函数，里面没有

    struct innerFuncStruct{
        char name[20];
    };

    innerFuncStruct innerFuncStruct = {
        "方法内部也可"
    };

    cout << "方法的内部也是可以定义结构的！！！！innerFuncStruct.name=" << innerFuncStruct.name << endl; 


    struct 连续声明
    {
        char name[30];
        int old;
    } 连续声明1 = {"连需声明1",
        15}, 连续声明2;    //这样写

    cout << " 连续声明1.name=" << 连续声明1.name << endl;    
    // 连续声明1.name = ""; 我靠竟然没有办法单个赋值！！！！！

    // 我已经不理解C++的写法了，凭什么不能脱离了这个来声明啊!
    连续声明2 = {
        "连续声明2",
        20
    };
    cout << " 连续声明1.name=" << 连续声明1.name << endl;    

    // 声明一个没有名称的结构
    struct {
        int x;
        int y;
    } position;

    //难道结构不能脱离声明之后再初始化？奇怪啊我勒个去！！！
    position = {
        0,
        0
    };
    return 0; //我真是服了， 把return0 写到前面竟然不报错！什么他妈的破语言啊！low死了！
}

