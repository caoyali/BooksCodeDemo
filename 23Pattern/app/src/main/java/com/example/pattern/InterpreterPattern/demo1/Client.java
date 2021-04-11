package com.example.pattern.InterpreterPattern.demo1;

class Client {
    public static void main(String[] args) {
        int result = InterpreterHelper.addAndSub("30+74+50-6+7");
        System.out.println("计算出来的结果是 result=" + result);
    }
}
