package com.example.generics;

/**
 * 电子书 485 页 , 编译器有多聪明？
 * 哈哈哈哈，事实证明，编译器并不是很聪明！
 * @param <T>
 */
public class AAB_Holder<T> {
    private T value;
    public AAB_Holder() {
    }

    public AAB_Holder(T value) {
        this.value = value;
    }

    public void set(T value) {
        this.value = value;
    }


    public T get() {
        return this.value;
    }


    public boolean equals(Object obj) {
        return value.equals(obj);
    }


    public static void main(String[] args) {
        AAB_Holder<Integer> integerHolder = new AAB_Holder<>(new Integer(1));
        Integer integer = integerHolder.get();
        integerHolder.set(integer);

//        AAB_Holder<Number> numberAABHolder = integerHolder;// 语法有问题
        AAB_Holder<? extends Number> numberHolder = integerHolder;  //没有语法错误。因为泛型涵盖了，概念上是可以的
        Number number = numberHolder.get(); //也没有语法报错，但是在运行的时候绝对有问题。所以泛型在这方面会比较容易出现问题的。

        integer = (Integer) number; //这一行也没有在语法上报错，事实上内部可能会乱的不成样了

        try {
            Long long1 = (Long) number; //这一行在运行的时候照样会出问题，类型不对
        } catch (Exception e) {

        }
        Class clazz = AAB_Holder.class;
    }
}
