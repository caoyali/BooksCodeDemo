#include <iostream>
# include <cmath>

int main(int argc, char const *argv[])
{
    using namespace std;
    double area;
    cout << "Enter the flooter area, in squara feet, of your home";
    cin >> area;
    double side;
    side = sqrt(area);
    cout << "side=" << side << endl;
    /* code */
    return 0;
}
