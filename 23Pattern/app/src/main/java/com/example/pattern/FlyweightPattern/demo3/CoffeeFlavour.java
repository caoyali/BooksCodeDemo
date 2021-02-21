package com.example.pattern.FlyweightPattern.demo3;

import android.annotation.SuppressLint;


import java.util.ArrayList;
import java.util.WeakHashMap;

/**
 * 语法好新啊！
 */
class CoffeeFlavour {
    /**
     * 为什么是final呢？原因是这个是共享对象，name这种东西是共享的，且对于很多种其他要共享的对象而言，这个就是不会改变的。
     */
    private final String name;
    private static final WeakHashMap<String, CoffeeFlavour> CATCH = new WeakHashMap<>();

    private CoffeeFlavour(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CoffeeFlavour{" +
                "name='" + name + '\'' +
                '}';
    }

    @SuppressLint("NewApi")
    public static CoffeeFlavour intern(String name) {
        synchronized (CATCH) {
            return CATCH.computeIfAbsent(name, CoffeeFlavour::new);  // 构造器明明有参数啊，这里怎么没有体现呀！
        }
    }

    public static int flavoursInCatch(){
        synchronized (CATCH) {
            return CATCH.size();
        }
    }

    interface Order{
        void serve();

        static Order of(String flavoureName, int tableNumber) {
            CoffeeFlavour coffeeFlavour = CoffeeFlavour.intern(flavoureName);
            return () -> {System.out.println("Serving " + coffeeFlavour + " to table " + tableNumber);
            System.out.println("这句话是我自己加的，测试lamta表达式");
            };
        }
    }

    static class CoffeeShop{
        private final ArrayList<Order> orders = new ArrayList<>();
        private void takeOrder(String flavoure, int tableNumber) {
            orders.add(Order.of(flavoure, tableNumber));
        }

        @SuppressLint("NewApi")
        public void service() {
            orders.forEach(Order::serve);
        }
    }

    public static class FlyweightExample{
        public static void main(String[] args) {
            CoffeeShop shop = new CoffeeShop();
            shop.takeOrder("Cappuccino", 2);
            shop.takeOrder("Frappe", 1);
            shop.takeOrder("Espresso", 1);
            shop.takeOrder("Frappe", 897);
            shop.takeOrder("Cappuccino", 97);
            shop.takeOrder("Frappe", 3);
            shop.takeOrder("Espresso", 3);
            shop.takeOrder("Cappuccino", 3);
            shop.takeOrder("Espresso", 96);
            shop.takeOrder("Frappe", 552);
            shop.takeOrder("Cappuccino", 121);
            shop.takeOrder("Espresso", 121);

            shop.service();
            System.out.println("CoffeeFlavor objects in cache: " + CoffeeFlavour.flavoursInCatch());
        }
    }
}
