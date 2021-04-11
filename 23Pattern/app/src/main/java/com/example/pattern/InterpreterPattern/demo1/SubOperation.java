package com.example.pattern.InterpreterPattern.demo1;

import androidx.annotation.NonNull;

class SubOperation extends ColOpration{

    public SubOperation(IOperation a, IOperation b) {
       super(a, b);
    }

    @Override
    public int operate() {
        int r =  a.operate() - b.operate();
        return r;
    }

    @NonNull
    @Override
    public String toString() {
        return "(" + a + "-" + b + ")";
    }
}
