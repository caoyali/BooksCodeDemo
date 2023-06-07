/**
 * @author caoyl
 * 
*/
#include<iostream>
#define show(x) printf("x=%d\n", (x))
#define show1(x) printf(#x"=%d\n", (x))
#define show2(x) printf(x"=%d\n", (x)) //糟了，语法压根就不过关，就，根本不允许这样写看来
#

// 对于双井号的语法， 你直接理解为拼接用的，就拼接字符串， 可以理解吧
/**
 * 我在看源码的时候看见了一个相当炸裂的写法，真的非常炸裂的那种，我要拿来抄一遍，就是用井号来进行拼接， 但是拼接的是，函数名！
 * 这也能拼接？我去！！简直了！！
 * 
 * #define RTC_CHECK_OP(name, op, val1, val2)
 *  if (std::string* _result = afanty_rtc::Check##name##Impl((val1), (val2), #val1 " " " $op" " #val2")) \
 *  afanty_rtc::FatalMessage(__FILE__, __LINE__, _result).stream();
 * 所以这个是干嘛的。比大比小这样写会不会有点画蛇添足啊。
*/

int main(){
    show(3); // 打印结果为 x=3, 注意，双引号扩住的就是平常的，就打印个x=
    // printf("x=%d", (3));  看吧，没加井号，一般默认为不进行替换看来
    show1(3); // 3=3  我是真不知道加井号的意思
    // printf("3=%d", (3)); 加了警告，意思是在字符串里面，要求替换。
    // show2(3);
    return 0;
}