package com.example.pattern.FlyweightPattern.demo1;

class Client {
    public static void main(String[] args) {
        FlyWeight flyWeight1 = FlayweightFactroy.getFlayweight("A");
        flyWeight1.operation();

        FlyWeight flyWeight2 = FlayweightFactroy.getFlayweight("B");
        flyWeight2.operation();

        FlyWeight flyWeight3 = FlayweightFactroy.getFlayweight("A");
        flyWeight3.operation();

        FlyWeight flyWeight4 = FlayweightFactroy.getFlayweight("B");
        flyWeight4.operation();
    }
}
