/**
 * @author caoyl
 * 本例子主要讲的是运算符的重载操作。 注意是运算符的重载，operator关键字就是用来做这个的！
*/

#include<iostream>
using namespace std;
class OperatorTest{
    private : 
        string name;
        int age;
    public :
        OperatorTest(string name, int age) : name(name), age(age){
            cout << "初始化一个人， 名字是： " << name << " 年龄是: " << age << endl;
        };

    public :
        /**
         * 使用方式，当对此对象用 == 号的时候，这段代码就会起作用，但是啊，我又好奇了，后面的参数，是操作数 右面的值？？？？？
         * 这里面必须有个规则的，到底是什么规则呢？
        */
        bool operator== (const OperatorTest& person) {
            cout << "传入的参数是： " << person.name << " : " << person.age << endl;
            cout << "本类的参数是： " << this-> name << " : " << this-> age << endl;
            return(this->age == person.age) && (this->name == person.name);
        }
};

int main(){
    OperatorTest o1("yayali1", 18);
    OperatorTest o2("yayali2", 19);
    // 到底 o1 是参数 还是 o2是参数呢？  调用的是 o1  o2 是以参数的形式存在！！！！！！！
    // 也就是后面的那个是参数，前面那个是被操作数。
    if (o1 == o2) {
        cout << "是一个人" << endl;
    } else {
        cout << "不是一个人" << endl;
    }
    return 0;
}

