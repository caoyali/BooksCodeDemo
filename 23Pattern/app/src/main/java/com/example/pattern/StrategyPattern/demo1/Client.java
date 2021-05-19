package com.example.pattern.StrategyPattern.demo1;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setBaseStrategy(new StrategyAdd());
        context.execute(1, 3);

        context.setBaseStrategy(new StrategySub());
        context.execute(3,2);
    }
}
