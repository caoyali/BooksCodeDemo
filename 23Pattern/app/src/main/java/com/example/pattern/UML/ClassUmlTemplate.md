# 类图模板
##### 继承 实线空三角
```puml
@startuml
Title 演示 B继承自A
class A
class B
A <|-- B
@enduml
```

##### 实现  虚线空三角
```puml
@startuml
Title 演示 B 实现了 A
interface A
class B
A <|.. B
@enduml
```

##### 关联  A 知道 B 的关系, 实现箭头。B 与 A 是八竿子打不着的关系，两个独立类，但是，A做某种事情，需要知道B怎么样。
```puml
@startuml
class A 
class B
A --> B
@enduml
```

##### 依赖 虚线箭头， B 与 A是八竿子打不着的关系，但是 A正常进行，必须依赖B，否则做不了东西
```puml
@startuml
class A 
class B
A ..> B
@enduml
```
##### 聚合 一种松散的拥有关系，A中包含B， 但是B对象并不一定要是A的一部分
```puml
@startuml
class A 
class B
A o-- B
@enduml
```

##### 组合 一种强的拥有关系，体现了非常严格的整体与部分关系, A 包含了 B, B 离了A无法独自存在，独自存在毫无意义
```puml
@startuml
class A
class B
A *-- B
@enduml
```

# 甘特图

### 定义/顺序/开始/结束
```puml
@startgantt

Project starts 2021-03-10
[Prototype design] lasts 10 days
[Code prototype] lasts 10 days
[Wright tests] lasts 5 days



[Test ProtoType] lasts 10 days
[Prototype design] starts 2021-03-10
[Test ProtoType] starts at [Prototype design]'s end
[Code prototype] starts at [Prototype design]'s end
[Wright tests] starts at [Code prototype]’s start
@endgantt
```

#### 简写名称/颜色/进度
```puml
@startgantt
[task 1] as [T1] lasts 1 week
[tast 2] as [T2] lasts 2 week
[T2] starts at [T1]'s end
[T1] is colored in #FF0000
[T2] is colored in yellow

[T1] is 40% completed
[T2] is 0% completed
@endgantt
```
### 里程碑： 相对/绝对/最终

#### 相对
```puml
@startgantt
[task 1] as [T1] lasts 10 days
[task 1 completed] happens at [T1]'s end
[Setup assembly line] as [T2] lasts 12 days
[T2] starts at [T1]'s end
@endgantt
```

#### 绝对
```puml
@startgantt
Project starts 2021-03-10
[task 1] as [T1] lasts 10 days
[task 1 completed] happens 2021-03-21
[Setup assembly line] as [T2] lasts 12 days
[T2] starts at [T1]'s end
@endgantt
```

#### 最终里程碑/以及更高级的声明顺序语法  happens
```puml
@startgantt
[Task 1] lasts 4 days
then [Task 1.1] lasts 4 days
[Task 1.2] starts at  [Task 1]'s end and lasts 7 days

[Task 2] lasts 5 days
then [Task 2.1] lasts 4 days

[Maxtaskend] happens at [Task 1]'s end
[Maxtaskend] happens at [Task 2]'s end
[Maxtaskend] happens at [Task 1.1]'s end
[Maxtaskend] happens at [Task 1.2]'s end
[Maxtaskend] happens at [Task 2.1]'s end
@endgantt
```

#### 绑定链接
```puml
@startgantt
[task1] lasts 10 days
[task1] links to [[http://baidu.com]]
@endgantt
```

#### 日历
```puml
@startgantt
Project starts the 20th of september 2021
[Prototype design] as [TASK1] lasts 13 days
[TASK1] is colored in Lavender/LightBlue
@endgantt
```

#### 日历颜色
```puml
@startgantt
Project starts the 2021/03/10
2021/03/12 is colored in salmon
2021/03/15 to 2021/03/18 are colored in lightblue

[Prototype design] as [TASK1] lasts 22 days
[TASK1] is colored in Lavender/LightBlue
[Prototype completed] happens at [TASK1]'s end

@endgantt
```

### 特殊单元块操作
关键词：
printscale
ganttscale
projectscale

关键词对应的值：
daily(默认)
weekly
monthly

#### 重点来啦！跳过节假日！完全自定义！关掉或开启特殊日期。牛皮啊！closed open关键词
```puml
@startgantt
saturday are closed
sunday are closed
2021/03/29 is closed  
2021/03/10 to 2021/03/19 is closed
Project starts the 2021/03/10
[Prototype design end] as [T1] lasts 19 days
[T1] is colored in Fuchsia/FireBrick
[Testing] as [T2] lasts 14 days
[T2] is colored in GreenYellow/Green
[T1] -> [T2]

[上线] lasts 1 days
[T2]->[上线]
@endgantt
```

#### 设置甘特图日历的展示格代表的单位 
```puml
@startgantt
printscale weekly
saturday are closed
sunday are closed
Project starts the 2021/03/10
[Prototype design end] as [T1] lasts 19 days
[T1] is colored in Lavender/LightBlue
[Testing] as [T2] lasts 14 days
[T1] -> [T2]

[上线] lasts 1 days
[T2]->[上线]

2021/03/12 is colored in salmon
2021/03/15 to 2021/03/18 are colored in lightblue
2021/03/15 to 2021/03/18 are named [End's committee]
@endgantt
```

### 顺序  then， -> 不做多余描述了。都行.

#### 高端使用！资源分配一目了然.谁什么时间段有时间都能看得出来

##### 时间精细调整，相对位置，以及谁哪段时间请假，所有的排期都跟着改变
解决了节假日，倒班日，员工资源， 员工请假等诸多复杂情况下的排期问题
```puml
@startgantt
<style>
ganttDiagram {
	task {
		FontName Helvetica
		FontColor red
		FontSize 18
		FontStyle bold
		BackGroundColor GreenYellow
		LineColor blue
	}
	milestone {
		FontColor blue
		FontSize 25
		FontStyle italic
		BackGroundColor yellow
		LineColor red
	}
	note {
		FontColor DarkGreen
		FontSize 10
		LineColor OrangeRed
	}
	arrow {
		FontName Helvetica
		FontColor red
		FontSize 18
		FontStyle bold
		BackGroundColor GreenYellow
		LineColor blue
	}
	separator {
		LineColor red
		BackGroundColor green
		FontSize 16
		FontStyle bold
		FontColor purple
	}
}
</style>
saturday are closed
sunday are closed
Project starts the 2021/03/10

[PRD] on {产品} lasts 2 days
then [产品讨论] on {leader} lasts 2 days
then [研发调研] on {曹娅丽} lasts 3 days
[UI设计] on {ui} lasts 5 days
'简化语法，指定了顺序。不过这种只是指定顺序而已！更高级的，需要码字
[产品讨论]->[UI设计]

[研发项目] on {曹娅丽} lasts 10 days

'这一句是高级语法，解决了不同团队的介入时间问题。
[研发项目] starts 3 days after [UI设计]'s start 
{曹娅丽} is off on 2021/03/26 to 2021/03/29
@endgantt
```