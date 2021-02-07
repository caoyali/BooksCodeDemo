package com.example.pattern.StatePattern.demo1;

class LowerCaseState implements State {
    @Override
    public void writeName(StateContext context, String name) {
        System.out.println(name.toLowerCase());
        // 已知当前的状态， 就是自己， 然后计算出下一个状态， 设置进去。之后context再次调用的时候，状态已经改变了。
        context.setState(new MultipleUpperCaseState());
    }
}
