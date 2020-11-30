package com.example.pattern.Adapter.objectAdapterDemo;

class AdapterPattern {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.request();
    }
}
