#include <iostream>

const char* chars[4] = {
    "青少年.\n",
    "中年.\n",
    "老年.\n",
    "长寿啊你.\n"
};

int main() {
    using namespace std;
    cout << "请输入你的年龄" << endl;
    int eag;
    cin >> eag;

    int index;
    if (eag < 30 && eag >= 0 ) {
        index = 0;
    } else if (eag < 60 && eag >= 30) {
        index = 1;
    } else if (eag < 90 && eag >= 60)
    {
      index = 2;
    } else if (eag < 120 && eag >= 90)
    {
        index = 3;
    }

    cout << "解释是：" << chars[index] << endl;
    return 0;
}