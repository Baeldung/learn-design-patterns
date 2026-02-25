package com.baeldung.ldp.factorymethod;

public class DatabaseTaskCreator extends TaskCreator {

    @Override
    public Task createTask(String name) {
        return new DatabaseTask(name);
    }
}
