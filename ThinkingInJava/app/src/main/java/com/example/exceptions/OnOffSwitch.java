package com.example.exceptions;

public class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2{}

//    public static void main(String[] args) {
//        sw.on();
//        try {
//            f();
//            sw.off();
//        } catch (OnOffException1 onOffException1) {
//            System.out.println("OnOffException1");
//            sw.off();
//        } catch (OnOffException2 onOffException2) {
//            System.out.println("OnOffException2");
//            sw.off();
//        }
//    }

    public static void main(String[] args) {
        sw.on();
        try {
            f();
            sw.off();
        } catch (OnOffException1 onOffException1) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 onOffException2) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
}
