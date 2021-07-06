package com.example.pattern.VisitorPattern.demo2;

public class SuccessAction extends Action {
    @Override
    public void getMainConclusion(Man man) {
        System.out.println("Success 姓名：" + man.get姓名() + " 性别：" + man.get性别());
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println("Success 姓名：" + woman.get姓名() + " 性别：" + woman.get性别());
    }
}
