# Visitor Pattern
访问者模式，顾名思义，就是专注于访问用的。这个模式吧，我初次看的时候觉得关系有些绕，绕着绕着我自己都快晕了。

```puml
interface IVisitor{
    void visitElementA(ElementA a);
    void visitElementB(ElementB b);
}
interface IElement{
    void accept(IVisitor visitor);
}

class ElementA{
    void accept(IVisitor visitor);
}
ElementA -up-|> IElement

class ElementB{
    void accept(IVisitor visitor);
}
ElementB -up-|> IElement

IElement .right.> IVisitor
IVisitor ..> IElement

class DataSturctor{
    - List<IElement> elementList;
    + acceptAll(IVisitor visitor);
    + addElement(IElement element);
    + cleanAllElement();
}
DataSturctor -right-> IElement
DataSturctor ..> IVisitor

class Client{
    + static main();
}
Client .down.> DataSturctor

```