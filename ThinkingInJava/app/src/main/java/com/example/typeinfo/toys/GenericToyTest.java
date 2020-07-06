package com.example.typeinfo.toys;

/**
 * 电子书403页，对class加上泛型约束之后，newInstance方法 就不用进行强制转型了。
 */
public class GenericToyTest {
    public static void main(String[] args) {

        try {
            Class<FancyToy> ftClass = FancyToy.class;
            // 对class加上类型约束之后，newInstance()得到的类型就不必执行强制转换了。这个编译期会通过的。
            FancyToy fancyToy = ftClass.newInstance();
            // super 关键字，描述的是这个类型是 FancyToy的父类。
            Class<? super FancyToy> up = ftClass.getSuperclass();
            Object obj = up.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
