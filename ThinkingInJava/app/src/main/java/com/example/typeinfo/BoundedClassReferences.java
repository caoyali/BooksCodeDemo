package com.example.typeinfo;

/**
 * 电子书402页
 * 重点语法： <? extends  Number> 来描述一个继承关系！？又叫通配符！<> 类型限定符的一个好处是，编译期进行类型检测
 * 大大提高排查错误的效率
 */
public class BoundedClassReferences {
    public static void main(String[] args) {

        Class<? extends  Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
    }
}
