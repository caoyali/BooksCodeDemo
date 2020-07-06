package com.example.typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * 电子书 394页
 * 由多态谈及动态类型
 */
abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes {
    public static void main(String[] args) {
        // 当这句话执行的时候，事实上已经发生了向上转型！
        // 编译时，进行类型检测，以至于在写代码的时候，就强制我们把类型给成了既定的样子 shape，但是对于shapeList
        // 而言，它存储的依旧是Object类型。为什么给你的假象是它存储的是你写好的尖括号里面的<Shape>？原因是
        // 这段代码在取出元素的时候，利用RTTI机制，在运行的最后，把类型转成既定的样子!
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());

        for (Shape shape : shapeList) {
            // 这段代码在取出元素的时候，利用RTTI机制，在运行的最后，把类型转成既定的样子!
            // 那么RTTI的大致机制是什么呢？在运行时检测所有的类型，以确保类型的正确性。在运行时，才给以确切的类型！
            shape.draw();
            System.out.println(shape);
        }
    }
}
