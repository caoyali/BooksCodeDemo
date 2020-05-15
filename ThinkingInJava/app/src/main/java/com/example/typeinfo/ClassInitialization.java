package com.example.typeinfo;

import com.example.util.print.Print;

import java.util.Random;

/**
 * 电子书 400 页， 讲述 类名.class 与 forName()得出的class有一个区别
 * 就是后者会涉及到初始化资源，但是 .class就不会初始化资源。
 */
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        Print.print("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        Print.print("Initializing Initable2");
    }
}

class Initable3 {
    static int ststaicNonFinal = 74;

    static {
        Print.print("Initializing Initable3");
    }
}
public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) {
//        Class initable = Initable.class;
        try {
            Class initable = Class.forName("com.example.typeinfo.Initable");
        } catch (ClassNotFoundException e) {
            Print.print("have an exception! e=" + e);
        }
//        Print.print("After creating Initable ref!");
//        Initable.staticFinal;
//        Print.print("Initable.ststicFinal");
    }
}
