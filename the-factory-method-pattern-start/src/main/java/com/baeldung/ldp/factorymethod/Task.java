package com.baeldung.ldp.factorymethod;

public abstract class Task {

    private Long id;
    private final String name;
    private TaskStatus status;

    public Task(String name) {
        this.name = name;
        this.status = TaskStatus.TO_DO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
