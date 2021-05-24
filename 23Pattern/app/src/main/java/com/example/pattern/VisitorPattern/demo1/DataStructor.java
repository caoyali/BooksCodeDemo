package com.example.pattern.VisitorPattern.demo1;

import java.util.ArrayList;
import java.util.List;

class DataStructor {
    private List<IElement> list = new ArrayList<>();

    public void addElement(IElement element) {
        list.add(element);
    }

    public void removeAll() {
        list.clear();
    }

    public void accept(IVisitor visitor) {
        for (IElement element : list) {
            element.accept(visitor);
        }
    }
}
