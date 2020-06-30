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
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());

        for (Shape shape : shapeList) {
            shape.draw();
            System.out.println(shape);
        }
    }
}
