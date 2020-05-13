package com.example.typeinfo;

/**
 * 纸质书 322页
 */
class Building {};
class House extends Building {};
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        // 为什么用一个基类的对象作为参数呀？
//        House h = houseType.cast(b);
        House h = (House) b;
        h = (House) b;
    }
}
