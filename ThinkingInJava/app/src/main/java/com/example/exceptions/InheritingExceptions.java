package com.example.exceptions;

/**
 * 纸质书 P251
 */

/**
 * 自定义的exception！
 * 对于异常来说，最最最重要的是，类名！
 */
class SimpleException extends Exception { }

public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions inheritingExceptions = new InheritingExceptions();
        try {
            inheritingExceptions.f();
        } catch (SimpleException si) {
            System.out.println("Caught it!");
        }
    }
}
