package com.example.pattern.StrategyPattern.demo1;

public class Context {
    private BaseStrategy baseStrategy;

    public void setBaseStrategy(BaseStrategy baseStrategy) {
        this.baseStrategy = baseStrategy;
    }

    int execute(int a, int b) {
       return baseStrategy.doOption(a, b);
    }
}
