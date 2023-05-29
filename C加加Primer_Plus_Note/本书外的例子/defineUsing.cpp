#include<iostream>
#define show(x) printf("x=%d\n", (x))
#define show1(x) printf(#x"=%d\n", (x))
#define show2(x) printf(x"=%d\n", (x)) //糟了，语法压根就不过关，就，根本不允许这样写看来
#

// 对于双井号的语法， 你直接理解为拼接用的，就拼接字符串， 可以理解吧

int main(){
    show(3); // 打印结果为 x=3, 注意，双引号扩住的就是平常的，就打印个x=
    // printf("x=%d", (3));  看吧，没加井号，一般默认为不进行替换看来
    show1(3); // 3=3  我是真不知道加井号的意思
    // printf("3=%d", (3)); 加了警告，意思是在字符串里面，要求替换。
    // show2(3);
    return 0;
}