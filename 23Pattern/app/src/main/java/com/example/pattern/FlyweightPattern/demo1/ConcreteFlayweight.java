package com.example.pattern.FlyweightPattern.demo1;

public class ConcreteFlayweight extends FlyWeight{
    ConcreteFlayweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    protected void operation() {
        System.out.println("ConcreteFlayweight operation extrinsic=" + extrinsic + " intrinsic" + getIntrinsic());
    }
}
