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
        // 其实我感觉下一句与下下句，差不多，而且第一句写起来有些麻烦。要我我不用这个方法
        House h = houseType.cast(b);
        House h1 = (House) b;
        h = (House) b;

    }
}
