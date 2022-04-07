#include <iostream>
using namespace std;
int main()
{
    struct Inflatable{
        string name;
        float volume;
        float price;
    };

    Inflatable* in1 = new Inflatable;
    cout << "Please Enter name:" << endl;
    // cin.get(in1 -> name, 20); //这样写不行，但是书上就是这么写的。这个C++是特么怎么回事啊！
    cin >> in1 -> name;
    cout << "Please Enter volume" << endl;
    cin >> (*in1).volume;
    cout << "Please Enter price" << endl;
    cin >> in1->price;

    cout << "Name=" << in1 -> name << endl;
    cout << "Volume=" << (*in1).volume << endl;
    cout << "Price=" << in1 -> price << endl;

    delete in1;

    return 0;
}