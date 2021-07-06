package com.example.pattern.VisitorPattern.demo2;

public abstract class Person {
    private String 性别 = "无";
    private String 姓名 = "佚名";
    public abstract void accept(Action  action);

    public String get姓名() {
        return 姓名;
    }

    public void set姓名(String 姓名) {
        this.姓名 = 姓名;
    }

    public String get性别() {
        return 性别;
    }

    public void set性别(String 性别) {
        this.性别 = 性别;
    }
}
