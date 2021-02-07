package com.example.pattern.StatePattern.demo1;

class MultipleUpperCaseState implements State{
    int count = 0;
    @Override
    public void writeName(StateContext context, String name) {
        System.out.println(name.toUpperCase());
        if (++count > 1) {
            context.setState(new LowerCaseState());
        }
    }
}
