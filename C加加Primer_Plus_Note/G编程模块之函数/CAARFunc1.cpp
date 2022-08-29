// 数组就是地址， 即使你定义的是地址，照样把形参当成数组来写就行！

// 第一种书写方式
// #include <iostream>
// int sum_aar(int* array, int length);
// int main() {
//     using namespace std;
//     const int size = 6; // const 在函数中如果想传常量，函数声明的时候必须也是常数！怎么这样啊！
//     int array[size] = {1, 2, 3, 4, 5, 6};
//     int result = sum_aar(array, size);
//     cout << "result=" << result << endl;
//     return 0;
// }

// int sum_aar(int* array, int length) {
//     int result = 0;  // 必须赋值！否则不知道是什么值！
//     int k = 0;
//     while (k < length)
//     {
//         result += array[k];
//         k++;
//     }
//     return result;
// }

// 第二种书写方式
#include <iostream>
int sum_aar(int array[], int length);
int main() {
    using namespace std;
    const int size = 6; // const 在函数中如果想传常量，函数声明的时候必须也是常数！怎么这样啊！
    int array[size] = {1, 2, 3, 4, 5, 6};
    int result = sum_aar(array, size);
    cout << "result=" << result << endl;
    return 0;
}

int sum_aar(int array[], int length) {
    int result = 0;  // 必须赋值！否则不知道是什么值！
    int k = 0;
    while (k < length)
    {
        result += array[k];
        k++;
    }
    return result;
}