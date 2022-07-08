# include <iostream>
# include <ctime>

int main() {
    using namespace std;

    cout << "Please enter a delay time in second!" << endl;

    int second;

    cin >> second;

    clock_t delay = second * CLOCKS_PER_SEC;
    cout << "starting \a\n";
    clock_t start = clock();

    while(clock() - start < delay) {
        //
    }

    cout << "done!" << endl;
    return 0;
}