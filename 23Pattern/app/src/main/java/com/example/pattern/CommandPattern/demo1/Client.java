package com.example.pattern.CommandPattern.demo1;

class Client {
    public static void main(String[] args) {
        CommandHelper helper = new CommandHelper();

        Executor executor = new Executor();
        helper.add(new JumpToACommand(executor));
        helper.add(new JumpToBCommand(executor));
        helper.add(new JumpToBBCCommand(executor));
        helper.back();

        helper.executeAll();
    }
}
