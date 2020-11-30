package com.example.pattern.Adapter.classAdapterDemo;

class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        this.specificRequest();
    }
}
