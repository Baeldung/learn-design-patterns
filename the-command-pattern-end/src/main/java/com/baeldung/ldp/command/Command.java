package com.baeldung.ldp.command;

public interface Command {

    void execute();

    void undo();
}
