# include <iostream>
# include <climits>
using namespace std;
int main() {
    cout << "char is "<< sizeof(char) << " bytes" << endl;
    cout << "short is" << sizeof(short) << " bytes" << endl; 
    cout << "int is" << sizeof(int) << " bytes" << endl; 
    cout << "long is" << sizeof(long) << " bytes" << endl; 
    cout << "long long is" << sizeof(long long) << " bytes" << endl; 

    cout << "MAX Values:" << endl;
    cout << "char: " << CHAR_MAX << endl;
    cout << "short: " << SHRT_MAX << endl;
    cout << "int: " << INT_MAX << endl;
    cout << "long: " << LONG_MAX << endl;
    cout << "int: " << INT_MAX << endl;

}