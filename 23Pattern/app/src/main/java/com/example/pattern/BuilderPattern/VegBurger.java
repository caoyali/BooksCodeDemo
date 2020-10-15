package com.example.pattern.BuilderPattern;

public class VegBurger extends Burger{
    @Override
    public float price() {
        return 15.0f;
    }

    @Override
    public String name() {
        return "Veg Burger!";
    }
}
