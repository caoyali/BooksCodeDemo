/**
 * @author caoyl
 * 本文件主要用于探究关于析构函数的生命周期。搞清的问题是
 * new 和 不new有什么区别
 * 什么时候析构
 * 
 * 首先通过这个例子我得到的结论是：
 * 1 对象，和new无关，对象不一定是new出来的，new 和 堆强相关，而不是和对象强相关。这个一定要记住的！你看下面的例子中，一个对象，有很多根本就没有用到new关键字，
 * 但是他们的构造方法照样被调用了。所以我得到的结论是和new无关。
 * 2 上述中，new这个关键字只是决定了这个对象是存在于堆中的！！！那么如果我们不通过new呢？我 想可能在栈中存在着。尽管我感觉这样写不太好，就，传递的时候，会存在大量的
 * 拷贝， 我觉得得拷贝，这样会慢。 
 * 3 对于new出来的对象，你必须用delete 关键字！来主动给它析构了！
 * 3 对于非new出来的对象，有一些情况存在自动会调用析构函数的情况。
 *      - 在方法中声明的，没有加特殊关键字，方法跑完，这家伙就析构了。
 *      - 在方法外部声明的，如果是成员变量，那么依附对象析构的时候他们也会被析构
 *      - 没在类里声明，它是个全局变量，那么在程序结束的时候被析构
 *      - static 修饰了，不管在哪里声明的，程序结束的时候被析构。
 * 
 * 5 对于 new出来的对象，非得delete才能析构么？即使是个成员变量，也得delete？
 * 
 * 
 * C++的对象
 * 可以new出来， 也可以不通过new出来。看看以下两种
 * Persion p = Persion("caoyl");
 * Persion p1 = new Persion(“caoyl”);
 * 嗯，两种都行，但是后面的那么，确定肯定一定，存在堆里！！！！！！
 * 现在记住这些就行了！
*/
#include<iostream>
using namespace std;

// 类的声明是否像java那样加访问域的关键字呢？
class CDemo{
    char name[20];

    public:
        // C++ 的构造函数，没有返回值，就像java那样，但是这里没有写，C++的构造函数也可以是私有的。这块跟java一样
        CDemo(){
            cout << "无参构造函数被调用" <<endl;
        }

        CDemo(char* namePtr) {
            cout << "调用有参数的构造函数" << endl;
            strcpy(name, namePtr);
            cout << "拷贝的名字是" << name << endl;
        }

        ~CDemo() {
            cout << "调用析构函数了, name是： " << name << endl;
        }
}; // 嗯， 类的声明最后是需要加分号的。

void func() {
    CDemo localObjectInfunction("LocalObjectInFunction");
    static CDemo StaticObject("staticObject");
    CDemo* pHeapObjectInFunc = new CDemo("HeapObjectInFunc");
    cout << "Inside func" << endl;
}

CDemo globalObject("GlobalOnject");

int main() {
    CDemo localMainFuncObject("localMainFuncObject");
    CDemo* pHeapObjectInMainFunc = new CDemo("pHeapObjectInMainFunc");
    cout << "目前在main方法中，开始调用func方法"<< endl;
    func();
    cout << "调用完func()方法了" << endl;
    return 0;
}

