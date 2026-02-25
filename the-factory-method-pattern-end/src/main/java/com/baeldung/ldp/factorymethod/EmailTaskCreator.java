package com.baeldung.ldp.factorymethod;

public class EmailTaskCreator extends TaskCreator {

    @Override
    public Task createTask(String name) {
        return new EmailTask(name);
    }
}
