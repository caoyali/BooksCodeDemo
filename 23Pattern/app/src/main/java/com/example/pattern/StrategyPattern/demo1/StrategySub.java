package com.example.pattern.StrategyPattern.demo1;

public class StrategySub implements BaseStrategy{
    @Override
    public int doOption(int a, int b) {
        return a - b;
    }
}
