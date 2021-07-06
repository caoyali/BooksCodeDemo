package com.example.pattern.VisitorPattern.demo2;

class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();

        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        SuccessAction successAction = new SuccessAction();
        objectStructure.display(successAction);
    }
}
