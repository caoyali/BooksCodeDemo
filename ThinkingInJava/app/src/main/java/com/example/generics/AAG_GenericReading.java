package com.example.generics;
import java.util.Arrays;
import java.util.List;

/**
 * 电子书487页
 * 泛型协变和通配符回顾例子
 */
public class AAG_GenericReading {
    /**
     * 很简单，读取以一个元素并返回。
     * 泛型只是用来定义规则的。说当前的这个类或者这个方法，要对什么样的"东西"做操作
     * @param list
     * @param <T>
     * @return
     */
    static <T> T readExcact(List<T> list) {
        return list.get(0);
    }

    /**
     * Arrays.asList 的内部实现本身就是泛型
     */
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());

    static void f1() {
        Apple a = readExcact(apples);
        Fruit f = readExcact(fruit);
        f = readExcact(apples); // 为什么这样可以啊    嗷嗷，向上转型的可以自动的
    }

    static class Reader<T>{
        T readExcect(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        Fruit f = fruitReader.readExcect(fruit);
//        Fruit a = fruitReader.readExcect(apples); //list是有泛型的，拿到的泛型是apple！与fruitReader已经定义好的Fruit是对不上的。
        // 泛型只是语法的检测，尽管两个类有关系，但是事实上差一个字都不行。java对泛型做的真的很少，根本就不记录泛型相关的类型信息，也就是人家压根就粗暴一点，一字一字的核对！差一点都不行！
        // 除非对泛型设置一个合理的范围。
    }

    static class CovariantReader<T> {
        T readConvariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        Fruit f = fruitReader.readConvariant(fruit);
        // 这句话是不行的。原因还是在于对应！apples是<Apple>, fruitReader 是<Fruit> ,
        // readConvariant 定义的是<? extends Fruit> 实际上这里没有任何问题。问题在于人家的返回值是<Fruit>"如果一一对应的话"
        // Fruit作为一个基类，是没有办法自由的向下转型的，除非你给个强制转型才可以。
//            Apple a = fruitReader.readConvariant(apples);
        Fruit a = fruitReader.readConvariant(apples);
    }

    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
