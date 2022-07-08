# include <iostream>

const int SIZE = 15;
int main() {
    using namespace std;
    int result[SIZE];
    result[0] = result[1] = 1;
    for (int i = 2; i < SIZE; i ++) {
        result[i] = i * result[i - 1];
    }

    for (int k = 0; k < SIZE; k++) {
        cout << k << "!=" << result[k] << endl;
    }
    return 0;
} 