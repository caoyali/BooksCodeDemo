package com.example.typeinfo.toys;

import com.example.util.print.Print;

/**
 * @author caoyali
 * 纸质书316
 */
interface HasBatteries {};

interface WaterPower {};

interface Shoots {};

class Toy {
    // Comment out the fllowing default constructor!
    // to see NoSuchMethodError from (*1*)
    Toy() {};
    Toy(int i) {};
}

class FancyToy extends Toy implements HasBatteries, WaterPower, Shoots{
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        Print.print("Class name: " + cc.getName()
        + " is interface ? [" + cc.isInterface() + "]");
        Print.print("Simple name: " + cc.getSimpleName());
        Print.print("Canonical name " + cc.getCanonicalName());// 这个是什么？
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.example.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            Print.print("can't find FancyJoy");
            System.exit(1);
        }
        printInfo(c);

        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        Object obj = null;

        try{
            obj = up.newInstance();
        } catch (InstantiationException ex) {
            Print.print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            Print.print("Cannot access");
            System.exit(1);
        }

        printInfo(obj.getClass());
    }
}


