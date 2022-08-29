#include <iostream>
void n_chars(char n, int times);

int main() {
    using namespace std;
    char n;


    cout<< "Enter a charactor!" << endl;
    cin >> n;
    int times;
    while (n != 'q')
    {   
        cout << "Please enter times" << endl;
        cin >> times;

        n_chars(n, times);

        cout<< "Enter a charactor!" << endl;
        cin >> n;        
    }
    return 0;
}

void n_chars(char n, int times) {
    using namespace std;
    while (times-- > 0)
    {
        cout << n;
    }
    cout << endl;
}
