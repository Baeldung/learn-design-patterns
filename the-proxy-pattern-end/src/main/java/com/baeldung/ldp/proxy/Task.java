package com.baeldung.ldp.proxy;

public class Task {

    private Long id;
    private String name;
    private TaskStatus status;

    public Task(Long id, String name, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
