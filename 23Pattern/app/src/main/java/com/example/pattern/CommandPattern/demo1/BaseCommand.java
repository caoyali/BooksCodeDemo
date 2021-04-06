package com.example.pattern.CommandPattern.demo1;

abstract class BaseCommand implements ICommand{
    protected Executor executor;
    protected BaseCommand(Executor executor){
        this.executor = executor;
    }
}
