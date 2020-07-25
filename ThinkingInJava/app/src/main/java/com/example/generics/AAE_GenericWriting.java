package com.example.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 电子书 486页
 * 重点看super与extends 与通配符合作之后形成的效果
 */
public class AAE_GenericWriting {
    /**
     * 该方法首先定义了一个方法级别的泛型，然后目的是在一个数组里面添加相应的元素。事实上
     * 我认为这么写有一些多余，也许是作者为了说明一些事情故意这样写的吧
     * 其实这个方法的写法是非常灵活的。
     * @param list
     * @param item
     * @param <T>
     */
    static <T> void writeExcact(List<T> list, T item) {
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruits = new ArrayList<Fruit>();
    static void f1() {
        writeExcact(apples, new Apple());
        writeExcact(fruits, new Apple()); // 我很奇怪为什么书上说这句会报错！
    }

    // 层级是T及T以上的类
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }

    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruits, new Apple());
    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
