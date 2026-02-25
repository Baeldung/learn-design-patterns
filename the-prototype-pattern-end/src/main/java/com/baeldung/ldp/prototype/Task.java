package com.baeldung.ldp.prototype;

public class Task {

    private Long id;
    private String name;
    private TaskStatus status;

    public Task(Long id, String name, TaskStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Task(Task other) {
        this.id = other.id;
        this.name = other.name;
        this.status = other.status;
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

    public void setName(String name) {
        this.name = name;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
