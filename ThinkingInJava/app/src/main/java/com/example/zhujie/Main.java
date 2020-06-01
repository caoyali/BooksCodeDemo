package com.example.zhujie;

import android.os.SystemClock;

import com.example.util.print.Print;

public class Main {
//    public static void main(String[] args) {
//        try {
//            Class c = Class.forName("com.example.zhujie.Person");
//
//            if (c.isAnnotationPresent(Design.class)) {
//                Design d = (Design) c.getAnnotation(Design.class);
//                Print.print("class anon d.author=" + d.author() + " d.data()" + d.data());
//            }
//
//            Method[] methods = c.getMethods();
//            for (Method m : methods) {
//                if (m.isAnnotationPresent(Design.class)) {
//                    Design d = m.getAnnotation(Design.class);
//                    Print.print("method anon d.author=" + d.author() + " d.data()" + d.data());
//                }
//            }
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

//    public static void main(String[] args) {
//        int[][] data = new int [10000000][10000000];
//
//        Print.print("赋值开始：time=" + System.currentTimeMillis());
//        for (int i = 0; i < data.length; i++) {
//            for (int k = 0; k < data[i].length; k++) {
//                data[i][k] = 1;
//            }
//        }
//
//        Print.print("赋值完成：time=" + System.currentTimeMillis());
//
//        Print.print("2 赋值开始：time=" + System.currentTimeMillis());
//        for (int i = 0; i < data.length; i++) {
//            for (int k = 0; k < data[i].length; k++) {
//                data[k][i] = 1;
//            }
//        }
//
//        Print.print("2 赋值完成：time=" + System.currentTimeMillis());
//    }


    public static void main(String[] args) {
        Print.print("开始-->" + System.currentTimeMillis());
        for (int i=0; i < 1000; i++) {
            System.currentTimeMillis();
        }

        Print.print("结束-->" + System.currentTimeMillis());

        Print.print("开始1-->" + System.currentTimeMillis());
        for (int k=0; k < 1000; k++) {
            SystemClock.elapsedRealtime();
        }
        Print.print("结束1-->" + System.currentTimeMillis());
    }
}
