package com.example.generics;


import java.util.ArrayList;
import java.util.List;

/**
 * 主要是写一些水果之间的关系。由于后面的例子用到的`太多了，不能凑活了
 * 纸质书 389页
 */
class Fruit {
}

class Apple extends Fruit {
};

class Jonanthan extends Apple {
};

class Orange extends Fruit {
};

public class AAF_CovariantArrays {
    static <T> void addList(List<? super T> list, T item) {
        list.add(item);
    }

    // supper 与 extends的却别在于，前者包含边界，后者不包含边界。
    static <T> void addList2(List<? super T> list, T item) {
        list.add(item);
    }

    static void addList3(List<? extends Apple> list, Jonanthan apple) {
//        list.add(apple);
    }

    static void addFruit(List<? extends Fruit> list) {
//        list.add(new Fruit());
//        list.add(new Apple());
//        list.add(new Orange());
    }

    static List<Fruit> fruits = new ArrayList<>();
    static List<Apple> apples = new ArrayList<>();
    static List<Jonanthan> jonanthans = new ArrayList<>();

    public static void main(String[] args) {
        addList(fruits, new Fruit());
        addList(fruits, new Apple());
        addList(fruits, new Orange());
        addList(fruits, new Jonanthan());
        addList(apples, new Apple());
//        addList(apples, new Fruit());
    }
}
