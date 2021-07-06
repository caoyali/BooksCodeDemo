package com.example.pattern.VisitorPattern.demo2;

import java.util.LinkedList;
import java.util.List;

public class ObjectStructure {
    private List<Person> elements = new LinkedList<>();

    public void attach(Person person) {
        elements.add(person);
    }

    public void detach(Person person) {
        elements.remove(person);
    }

    public void display(Action action) {
        for (Person person : elements) {
            person.accept(action);
        }
    }
}
