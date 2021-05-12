package com.example.pattern.MementoPattern.demo1;

import java.util.Stack;

class CareTaker {
    private Stack<Memento> task  = new Stack<>();
    public void add(Memento memento) {
        task.push(memento);
    }

    public Memento back() {
        return task.pop();
    }
}
