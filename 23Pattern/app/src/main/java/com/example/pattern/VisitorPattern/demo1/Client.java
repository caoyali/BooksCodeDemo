package com.example.pattern.VisitorPattern.demo1;

public class Client {
    public static void main(String[] args) {
        DataStructor structor = new DataStructor();
        structor.addElement(new StudentElement("小红", 100, 8));
        structor.addElement(new StudentElement("小蓝", 90, 2));
        structor.addElement(new StudentElement("小绿", 85, 6));

        structor.addElement(new TeacherElement("张老师", 100, 4));

        Visitor visitor = new Visitor();
        structor.accept(visitor);

    }
}
