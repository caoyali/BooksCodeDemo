package com.example.typeinfo.toys;

public class GenericToyTest {
    public static void main(String[] args) {

        try {
            Class<FancyToy> ftClass = FancyToy.class;
            FancyToy fancyToy = ftClass.newInstance();
            Class<? super FancyToy> up = ftClass.getSuperclass();
            Object obj = up.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
