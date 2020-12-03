package com.example.pattern.Bridge.BridgeDemo1;

class ConcreteImplementorB implements Implementor{
    @Override
    public void operationImpl() {
        System.out.println("具体实现化(Concrete Implementor B)角色被访问");
    }
}
