package com.baeldung.ldp.prototype;

import java.time.LocalDate;

public class Task implements Prototype<Task> {

    private Long id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;

    public Task() {
    }

    public Task(String name, LocalDate dueDate, TaskStatus status) {
        this.name = name;
        this.dueDate = dueDate;
        this.status = status;
    }

    Task(Task source) {
        this.name = source.name;
        this.description = source.description;
        this.dueDate = source.dueDate;
        this.status = source.status;
    }

    @Override
    public Task copy() {
        return new Task(this);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
