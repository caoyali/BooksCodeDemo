package com.example.pattern.FlyweightPattern.demo2;

public class ConcreteFlyweight implements Flyweight{
    private Character intrinsicState = null;

    public ConcreteFlyweight (Character intrinsicState) {
        this.intrinsicState = intrinsicState;
    }
    @Override
    public void operation(String extrinsicState) {
        System.out.println("IntrinsicState=" + intrinsicState);
        System.out.println("ExtrinsicState=" + extrinsicState);
    }
}
