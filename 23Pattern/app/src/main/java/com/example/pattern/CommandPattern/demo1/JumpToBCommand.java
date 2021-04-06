package com.example.pattern.CommandPattern.demo1;

class JumpToBCommand extends BaseCommand{
    protected JumpToBCommand(Executor executor) {
        super(executor);
    }

    @Override
    public void execute() {
        this.executor.jumpToB();
    }
}
