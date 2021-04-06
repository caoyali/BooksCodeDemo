package com.example.pattern.CommandPattern.demo1;

class JumpToACommand extends BaseCommand{
    protected JumpToACommand(Executor executor) {
        super(executor);
    }

    @Override
    public void execute() {
        this.executor.jumpToA();
    }
}
