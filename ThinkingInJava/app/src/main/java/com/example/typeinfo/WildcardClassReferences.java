package com.example.typeinfo;

/**
 * 电子书第402页
 * 从之前我们学过的内容里面，class是支持泛型约束的，但是对于Class而言<Number> 与 <Integer> 是有很重要的区别的。
 * 在Class中不能像平常类那样的约束。其实这个是比较容易理解的。@see {@link GenericClassReferences}这个里面有相关
 * 的示例
 * 本代码主要讲述的是 问号 ？ 的使用，首先是？号的简单语法，接下来是？的使用@see{@link BoundedClassReferences}
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
