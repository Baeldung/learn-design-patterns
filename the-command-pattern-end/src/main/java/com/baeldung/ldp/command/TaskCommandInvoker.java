package com.baeldung.ldp.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskCommandInvoker {

    private final Deque<Command> history = new ArrayDeque<>();

    public void execute(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (history.isEmpty()) {
            return;
        }
        history.pop().undo();
    }
}
