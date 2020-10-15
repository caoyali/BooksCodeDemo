package com.example.pattern.BuilderPattern.Demo1;

public class Pepsi extends ColdDrink{
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
