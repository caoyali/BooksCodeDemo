package com.example.pattern.CommandPattern.demo1;

import java.util.ArrayList;
import java.util.List;

class CommandHelper {
    List<ICommand> commands = new ArrayList<>();

    void add(ICommand command) {
        commands.add(command);
    }

    void remove(ICommand command) {
        commands.remove(command);
    }

    void back() {
        commands.remove(commands.size() - 1);
    }

    void next() {
        System.out.println("下一步实现起来有些复杂，先不做了");
    }

    void executeAll() {
        for (ICommand command : commands) {
            command.execute();
        }
    }

}
