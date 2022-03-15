#include <iostream>
struct inflatable{
    char name[20];
    float volume;
    double price;
};

int main() {
    using namespace std;
    inflatable guest = {
        "Caoyali quest",
        1.88,
        29.99
    };

    inflatable pal = {
        "Caoyali pal",
        3.12,
        32.99
    };

    cout << "U have init guest! guest.name=" << guest.name << endl;
    cout << "U have init pal! pal.name=" << pal.name << endl;

    cout << "bose guest anf pal have " << guest.price +pal.price  << " Prices!" << endl;
}

