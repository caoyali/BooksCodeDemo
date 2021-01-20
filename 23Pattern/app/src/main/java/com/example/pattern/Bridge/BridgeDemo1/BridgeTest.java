package com.example.pattern.Bridge.BridgeDemo1;

class BridgeTest {
    public static void main(String[] args) {
        // ConcreteImplementorA 的句柄是更高抽象的接口，这样容易维护
        Implementor implementor = new ConcreteImplementorA();
        // RefinedAbstraction 的句柄依然是更高抽象的一个抽象类。与上面的意义相同。
        // 这也教会我们了一个很好的编码规范，就是能抽象的，不要用具体！
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.operation();
    }
}
