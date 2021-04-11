package com.example.pattern.InterpreterPattern.demo1;

class Value implements IOperation{
    int value = 0;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public int operate() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
