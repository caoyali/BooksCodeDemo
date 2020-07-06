package com.example.typeinfo;

/**
 * 我们可以对Class的生成类型进行约束。如：Class<Integer> genericIntClass = int.class;
 * 加上<Integer> 会使编译器强制进行类型检测
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class;
//        genericIntClass = double.class; 编译不通过

//        Class<Number> number = int.class; 这句话也编译不通过，尽管Integer继承自Number类，但是Class来讲，
        // 这两个是不同的类型，所以不能这样用！
    }
}

