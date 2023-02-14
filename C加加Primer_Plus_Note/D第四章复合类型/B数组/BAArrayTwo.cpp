#include<iostream>

void printArray(int arraySize);

int main() {
    using namespace std;
    int size;
    cin>> size;
    printArray(size);
    return 0;
}

void printArray(int arraySize) {
    using namespace std;
    int array[arraySize];
    for(int i = 0; i < arraySize; i ++) {
        cout << i << endl;
    }
}