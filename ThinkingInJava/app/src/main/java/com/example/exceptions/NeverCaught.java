package com.example.exceptions;

/**
 * 电子书330页
 */
public class NeverCaught {
    static void f(){
        // 尽管你的代码中写了 throw 一个exception，但是编译器似乎未要求你一定在方法上写throws这个关键字
        throw new RuntimeException("From f()");
    }

    static void g() {
        // 尽管f中的逻辑 throw了一个异常，但是，编译器还是跳过了 try catch的检测！
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
