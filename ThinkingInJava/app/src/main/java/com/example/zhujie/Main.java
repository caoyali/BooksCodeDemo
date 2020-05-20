package com.example.zhujie;

import com.example.util.print.Print;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("com.example.zhujie.Person");

            if (c.isAnnotationPresent(Design.class)) {
                Design d = (Design) c.getAnnotation(Design.class);
                Print.print("class anon d.author=" + d.author() + " d.data()" + d.data());
            }

            Method[] methods = c.getMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(Design.class)) {
                    Design d = m.getAnnotation(Design.class);
                    Print.print("method anon d.author=" + d.author() + " d.data()" + d.data());
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
