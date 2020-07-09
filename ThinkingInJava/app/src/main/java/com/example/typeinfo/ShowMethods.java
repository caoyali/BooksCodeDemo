package com.example.typeinfo;

import com.example.util.print.Print;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 纸质书 335 页
 */
public class ShowMethods {
    private static String usage = "usage: \n" + "ShowMethods qualified.class.name \n To show all methods in class or \n"
            + "SomeMethods qualified.class.name.word to search for methods involving world";

    private static Pattern p = Pattern.compile("\\w+\\."); // ????????什么意思？
    public static void main(String[] args) {
        Print.print("args=" + args.toString());
        if (args.length < 1) {
            Print.print(usage);
            System.exit(0);
        }

        int lines = 0;
        try {
            // args是一个字符串数组！
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    Print.print(p.matcher(method.toString()).replaceAll(""));
                }

                for (Constructor constructor : constructors) {
                    Print.print(p.matcher(constructor.toString()).replaceAll(""));
                }

                lines = methods.length + constructors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        Print.print(p.matcher(method.toString()).replaceAll(""));
                    }
                    lines ++;
                }

                for (Constructor constructor : constructors) {
                    if (constructor.toString().indexOf(args[1]) != -1) {
                        Print.print(p.matcher(constructor.toString()).replaceAll(""));
                    }
                    lines ++;
                }
            }
        } catch (ClassNotFoundException e) {
            Print.print("No such class e=" + e);
        }
    }
}
