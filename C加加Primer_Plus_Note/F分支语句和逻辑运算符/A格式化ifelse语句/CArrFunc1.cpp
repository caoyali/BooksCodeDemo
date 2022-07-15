#include <iostream>
using namespace std;

const int mArraySize = 8;

int countArry(int array[], int length);
int main(){
    int array[mArraySize] = {1, 2, 3, 4, 5, 6, 7, 8};
    int result = countArry(array, mArraySize);
    cout << "The result is: " << result << endl;
    return 0;
}

int countArry(int array[], int length) {
    int result = 0;
    for (int i = 0;  i < length; i ++) {
        result += array[i];
    }

    return result;
}

