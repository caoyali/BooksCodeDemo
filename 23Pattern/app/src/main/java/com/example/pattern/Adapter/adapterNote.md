# 适配器模式
##### 主要作用
解决接口之间的不兼容问题，用于包装不兼容的对象，使原本由于接口不兼容而不能在一起工作的哪些类可以在一起工作。
##### 分类

- 类的适配器模式
- 对象的适配器模式
#### 类的适配器模式
类的适配器模式是把适配的类的API转换成为目标类的API
```puml
@startuml
Title 类的适配器模式类图
interface Target {
    目标角色希望调用这个类的以下方法，来完成他们期望的操作。无视具体实现
    ..
    + request()
}
class Adaptee {
    实际上真正执行的逻辑
    ..
    + specificRequest()
}
class Adapter {
    适配器：把原接口转换成目标接口
    ..
    + request()
}
note left of Target : （目标角色，期待得到的接口）
note right of Adaptee : （源角色 : 需要适配的接口）
note bottom of Adapter : (适配器角色， 把原接口转换成目标接口)
Adaptee <|-- Adapter : 适配
Target <|.. Adapter : 被目标用户使用
@enduml
```
#### 对象的适配器模式
对象的适配器模式，本质上也是一样的道理，但是不同的是，对象的适配器模式不是使用的继承关系链接到Adaptee类，而是使用委派关系连接到Adaptee类的。

##### uml
```puml
@startuml
interface Target {
    + request()
}
class Adaptee {
    + SpecificRequest()
}
class Adapter {
    - Adaptee adaptee
    + request()
}
Target <|.. Adapter
Adaptee <.. Adapter
@enduml
```
