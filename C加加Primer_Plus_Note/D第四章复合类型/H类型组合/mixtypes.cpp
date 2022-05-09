# include <iostream>

struct antarctica_years_end
{
    int year;
};

int main() {
    antarctica_years_end s01, s02, s03;
    s01.year = 1998;

    antarctica_years_end *pa = &s02;
    pa -> year = 1999;

    antarctica_years_end tiro[3];
    tiro[0].year = 2003;
    using namespace std;
    cout << "tiro[0]=" << tiro[0].year << endl;

    const antarctica_years_end *p3[3] = {&s01, &s02, &s03};
    cout << p3[0]->year << endl;
    const antarctica_years_end **pp3 = p3;
    cout << (*pp3) -> year << endl;
    cout << (*(pp3 + 1)) -> year << endl;
    return 0;
}