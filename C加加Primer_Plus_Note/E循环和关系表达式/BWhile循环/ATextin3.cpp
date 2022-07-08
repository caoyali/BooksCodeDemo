# include <iostream>

using namespace std;
int main() {
    int count = 0;
    char ch;
    cin >> ch;
    while(ch != '#') {
        cout << ch;
        ++ count;
        cin >> ch;
    }

    cout << "endl" << count << " characters read!" << endl;
    return 0;
}