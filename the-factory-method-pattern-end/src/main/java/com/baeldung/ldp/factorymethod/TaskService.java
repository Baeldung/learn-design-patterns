package com.baeldung.ldp.factorymethod;

public class TaskService {

    private final TaskCreator taskCreator;

    public TaskService(TaskCreator taskCreator) {
        this.taskCreator = taskCreator;
    }

    public Task createTask(String name) {
        return taskCreator.createTask(name);
    }
}
