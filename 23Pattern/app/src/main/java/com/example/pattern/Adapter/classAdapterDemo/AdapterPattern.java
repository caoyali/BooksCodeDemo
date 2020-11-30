package com.example.pattern.Adapter.classAdapterDemo;

class AdapterPattern {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
