package com.example.pattern.BuilderPattern.Demo1;

public class ChickenBurger extends Burger{
    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken burger";
    }
}
