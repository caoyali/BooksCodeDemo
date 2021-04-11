package com.example.pattern.InterpreterPattern.demo1;

class AddOperation extends ColOpration{

    public AddOperation(IOperation a, IOperation b) {
        super(a, b);
    }

    @Override
    public int operate() {
        return a.operate() + b.operate();
    }

    @Override
    public String toString() {
        return "(" + a + "-" + b + ")";
    }
}
