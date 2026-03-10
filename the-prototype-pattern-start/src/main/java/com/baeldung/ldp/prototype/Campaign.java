package com.baeldung.ldp.prototype;

import java.util.ArrayList;
import java.util.List;

public class Campaign {

    private Long id;
    private String name;
    private String description;
    private List<Task> tasks;

    public Campaign() {
        this.tasks = new ArrayList<>();
    }

    public Campaign(String name, String description) {
        this.name = name;
        this.description = description;
        this.tasks = new ArrayList<>();
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}
