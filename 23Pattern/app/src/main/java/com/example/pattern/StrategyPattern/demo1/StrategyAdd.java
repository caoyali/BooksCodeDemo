package com.example.pattern.StrategyPattern.demo1;

public class StrategyAdd implements BaseStrategy{
    @Override
    public int doOption(int a, int b) {
        return a + b;
    }
}
