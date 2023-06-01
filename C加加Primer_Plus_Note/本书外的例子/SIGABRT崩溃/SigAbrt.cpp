/**
 * 本代码复现传说中的sigabrt问题
*/
#include "stdlib.h"
#include "string.h"
#include "stdio.h"
void testFree();
void testAbort();
void testAssert();

int main() {
    // testFree();
    testAbort();
    return 0;
}

void testFree() {
    /**
     * 多次调用free函数，会导致sig
    */
    void * pc = malloc(1024);
    free(pc);
    // free 函数，是用来释放通过 calloc， malloc， 和 realloc 方式所分配的空间。 这几个函数都是分配空间用的，只不过为了方便，就区分了这些方法
    free(pc);
    printf("free 释放完成!");
}

void testAbort() {
    /**
     * abort函数是干嘛的？
     * 程序出现严重问题的时候， 会调用abort函数， 会导致程序异常终止，而并不会进行一些清除工作，比如释放内存，都不带执行的。
     * abort()函数导致所有的流被关闭和冲洗。 不是很安全啊
     * 
     * 与之对应的是 exit()
     * exit()用来正常终结目前进程的执行,并把参数 status 返回给父进程,而进程所有的缓冲区数据会自动写回并关闭未关闭的文件。它并不像abort那样不做任何清理工作就退出，而是在完成所有的清理工作后才退出程序。
    */
    printf("调用abort函数之前");
    abort();
    printf("调用abort函数之后");
}

void testAssert() {
    
}