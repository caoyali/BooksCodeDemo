
package com.example.generics;
class Automobile {}

/**
 * 纸质书353页 泛型， 简单泛型
 * 这个类的作用很简单，就是初始化的时候带上一个参数，存储下来等待get的时候再吐出来。
 * 但是这个类对于泛型这个知识点而言，他的可重用性不太好！
 */
public class Holder1{
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}