package com.example.pattern.VisitorPattern.demo2;

class Woman extends Person{
    @Override
    public void accept(Action action) {
        action.getWomanConclusion(this);
    }
}
