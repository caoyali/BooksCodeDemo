/**
 * 本代码研究四种强制类型转换的区别
 * static_cast
 * reinterpret_cast
 * const_cast
 * dynamic_cast
*/

#include <iostream>
using namespace std;
class Static_Cast_A {
    public:
        operator int() {return 1;}
        operator char*() {return NULL;}
};

class Reinterpret_Cast_A {
    public:
        int i;
        int j;
        Reinterpret_Cast_A(int a) : i(a), j(a){}
        ~Reinterpret_Cast_A(){}
};

void testStaticCast();
void testReinterpretCast();
void testConstCast();
void testDynamicCast();

int main() {
        testStaticCast();
        return 0;
}

/**
 * static_cast关键词适合一些比较简单的类型转换， 但是你要是故意复杂的去用也是可以的！大致用法包含
 * 1 基本类型相互转换
 * 2 指针引用转换，可以由父类转向子类，也可以🈶子类转向父类，但是运行时不进行类型检查，这点需要程序员自己注意
 * 3 把空指针转换为目标类型的空指针
 * 4 把任何类型的表达式转换为void
*/
void testStaticCast(){
    Static_Cast_A a; //看哈，这是一个值！只要是值， 就一定会有空间的。
    int n;
    string p = "tyqwtwyu";

    n = static_cast<int> (3.14);
    n = static_cast<int> (a); //我靠，operator是为了隐式转换或者强制转换存在的？
    // p = static_cast<char*> (a);
    // n = static_cast<int> (p); //编译错误， 不可以将指针转换为整型的。
    // p = static_cast<char*> (n); //编译错误，static_cast 不能将整型转换为指针。
}

/**
 * 从英文的字面意思是，re  interpret 重新诠释。 这个的细节会涉及到字节复制，重新诠释的转型。
 * 任意指针或者引用类型之间的转换，以及指针与足够大的整数类型之间的转换，从整数类型到指针类型，无视大小，就是所有都可以转，不报错。
*/
void testReinterpretCast() {

}

/**
 * 你可以理解为，仅仅用于去除const属性的转换就行了。它是四个强制类型转换运算符中唯一能去除const属性的运算符。
*/
void testConstCast(){
    const string s = "iefoijewiov";
    string& sRef = const_cast<string&> (s);
    string* sPtr = const_cast<string*> (&s);
}

/**
 * 带安全检查的强制转换！ 带安全检查带安全检查，这个很重要给我往死里记！
 * 就是专门用于将多态基类的指针强制转换为派生类的指针或者引用，而且能够在运行期的时候检查转换的安全性，如果检查出不安全的话，转换结果会返回一个NULL指针。所以这样写之后最好
 * 对结果加上判断。来确保程序能够正确运行。
 * 
 * 但是这个关键字就是用来解决父类转子类的，在其他的地方你不能用， 比如，两个类根本就是八竿子打不着的关系，你转。就不会，。非要转，用那个reInterpret_cast去。这家伙对这块放的极宽！
 * 但是小心使用，因为它不安全。
*/
void testDynamicCast(){

}