package com.example.pattern.CommandPattern.demo1;

class JumpToBBCCommand extends BaseCommand{
    protected JumpToBBCCommand(Executor executor) {
        super(executor);
    }

    @Override
    public void execute() {
        this.executor.jumpToBBC();
    }
}
