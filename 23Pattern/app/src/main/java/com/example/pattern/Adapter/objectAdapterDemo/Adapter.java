package com.example.pattern.Adapter.objectAdapterDemo;

class Adapter implements Target{
    Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.SpecificRequest();
    }
}
