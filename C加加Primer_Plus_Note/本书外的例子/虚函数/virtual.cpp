#include <iostream>
using namespace std;
class Base{
    public:
    // Base(){
    //     cout << "基类的构造方法" << endl;
    // }

    virtual void hello2() {
        cout << "Base hello world 2!" << endl;
    }

    void hello() {
        cout << "Base hello world!" << endl;
        hello2();
    }
};

class SubClass : Base {
    public:
    // SubClass(){
    //     cout << "子类的构造方法" << endl; 
    // }

    void hello2() {
        cout << "sub hello world 2!" << endl;
    }


    virtual void hello() {
        cout << "Sub hello world!" << endl;
        hello2();
    }
};

int main() {

    Base baseRef;
    SubClass subRef;

    baseRef.hello();
    subRef.hello();

}