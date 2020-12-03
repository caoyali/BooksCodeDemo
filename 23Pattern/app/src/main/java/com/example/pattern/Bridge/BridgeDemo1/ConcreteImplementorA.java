package com.example.pattern.Bridge.BridgeDemo1;

class ConcreteImplementorA implements Implementor{
    @Override
    public void operationImpl() {
        System.out.println("具体实现化（Concrete Implementor A）角色被访问");
    }
}
