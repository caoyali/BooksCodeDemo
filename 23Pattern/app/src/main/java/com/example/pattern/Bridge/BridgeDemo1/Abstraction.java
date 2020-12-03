package com.example.pattern.Bridge.BridgeDemo1;

abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction (Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}
