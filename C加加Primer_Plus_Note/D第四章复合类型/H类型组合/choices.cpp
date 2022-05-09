# include <vector>
# include <array>
# include <iostream>
int main() {
    using namespace std;
    double oldDouble[4] = {0.1, 0.2, 0.3, 0.4};
    vector<double> vectorA(4);
    vectorA[0] = 1.1;
    vectorA[1] = 1.2;
    vectorA[2] = 1.3;
    vectorA[3] = 1.4;

    array<double, 4> arrayA = {2.1, 2.2, 2.3, 2.4};
    array<double, 4> arrayB;

    arrayB = arrayA;
    cout << "oldDouble[2]=" << oldDouble[2] << " at " << &oldDouble[2] << endl;
    cout << "vectorA[2]=" << vectorA[2] << " at " << &vectorA[2] << endl;
    cout << "arrayA[2]=" << arrayA[2] << " at " << &arrayA[2] << endl;
    cout << "arrayB[2]=" << arrayB[2] << " at " << &arrayB[2] << endl;

    // oldDouble[-2] = 20.2;
    // cout << "oldDouble[-2]=" << oldDouble[-2] << " at " << &oldDouble[-2] << endl;
    return 0;
}