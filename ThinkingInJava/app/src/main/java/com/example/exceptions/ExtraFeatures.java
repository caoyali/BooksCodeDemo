package com.example.exceptions;

import androidx.annotation.Nullable;

import com.example.util.print.Print;

/**
 * 纸质书 254
 * e.printStackTrace 会打印getMessage里面得到的东西，getMe把ssage首先会打印 msg内容。
 * 之后就会对应的栈的前两层打印出来！
 */
class MyException2 extends Exception {
    private int x;
    public MyException2(){};
    public MyException2(String msg) {
        super(msg);
    }

    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() {
        return x;
    }

    @Nullable
    @Override
    public String getMessage() {
        return "Detail Message: " + super.getMessage();
    }
}
public class ExtraFeatures {
    public static void f() throws MyException2 {
        Print.print("Throwing MyException2 from f()");
        throw new MyException2();
    }

    public static void g() throws MyException2 {
        Print.print("Throwing MyException2 from g()");
        throw new MyException2("Originated in g()");
    }

    public static void h() throws MyException2 {
        Print.print("Throwing MyException2 from h()");
        throw new MyException2("Throwing MyException2 from h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
            System.out.println("e.val() = " + e.val());
        }
    }
}
