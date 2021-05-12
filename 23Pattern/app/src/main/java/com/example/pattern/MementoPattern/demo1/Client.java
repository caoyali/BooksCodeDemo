package com.example.pattern.MementoPattern.demo1;

class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Originator originator = new Originator();
        originator.append("a");
        taker.add(originator.takeMemento());

        originator.append("yayali");
        taker.add(originator.takeMemento());

        originator.append("666666");
        taker.add(originator.takeMemento());

        originator.restore(taker.back());
        System.out.println(originator);

        originator.restore(taker.back());
        System.out.println(originator);

        originator.restore(taker.back());
        System.out.println(originator);
    }
}
