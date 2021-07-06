package com.example.pattern.VisitorPattern.demo2;


public class Man extends Person{
    @Override
    public void accept(Action action) {
        action.getMainConclusion(this);
    }
}
