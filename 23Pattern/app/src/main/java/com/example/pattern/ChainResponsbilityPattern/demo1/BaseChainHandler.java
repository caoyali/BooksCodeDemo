package com.example.pattern.ChainResponsbilityPattern.demo1;

abstract class BaseChainHandler {
    protected BaseChainHandler next;

    public BaseChainHandler(BaseChainHandler next) {
        this.next = next;
    }

    abstract void handle(int days);
}
