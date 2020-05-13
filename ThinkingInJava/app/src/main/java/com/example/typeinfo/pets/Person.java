package com.example.typeinfo.pets;

/**
 * 个人的，独特的，个人
 * 纸质书324
 */
class Individual{
    private String name;

    public Individual(String name) {
        this.name = name;
    }

    public Individual() {
    }
}
public class Person extends Individual{
    public Person(String name) {
        super(name);
    }
}
