package com.example.pattern.InterpreterPattern.demo1;

abstract class ColOpration implements IOperation{
    IOperation a;
    IOperation b;

    public ColOpration(IOperation a, IOperation b) {
        this.a = a;
        this.b = b;
    }
}
