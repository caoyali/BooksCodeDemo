#include <iostream>
int main() 
{
    using namespace std;
    const int size = 20;
    char name[size];
    char dessert[size];

    cout << "Enter your name:" << endl;
    cin >> name;
    cout << "Enter your favorite dessert:\n";
    cin >> dessert;
    cout << "I have some delicious " << dessert;
    cout << " Fot you, " << name << " .\n";
    return 0;
}