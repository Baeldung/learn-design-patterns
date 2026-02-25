package com.baeldung.ldp.factorymethod;

public class TaskService {

    public Task createTask(String type, String name) {
        if ("email".equals(type)) {
            return new EmailTask(name);
        } else if ("database".equals(type)) {
            return new DatabaseTask(name);
        }
        throw new IllegalArgumentException("Unknown task type: " + type);
    }
}
