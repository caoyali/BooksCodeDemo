package com.example.exceptions;

/**
 * 电子书  332页
 */
class ThreeException extends Exception {};

public class FinallyWorks {
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                if (count ++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No exception!");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                // finally 无论try块里面的逻辑是不是正常执行，都会执行这个闭包里面的代码！
                System.out.println("In finally clause");
                if (count == 2) break;
            }
        }
    }
}
