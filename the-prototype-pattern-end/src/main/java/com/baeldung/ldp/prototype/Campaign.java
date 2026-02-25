package com.baeldung.ldp.prototype;

import java.util.HashSet;
import java.util.Set;

public class Campaign {

    private Long id;
    private String name;
    private String code;
    private Set<Task> tasks;

    public Campaign() {
    }

    public Campaign(Campaign other) {
        this.name = other.name;
        this.code = other.code;
        this.tasks = new HashSet<>();
        for (Task task : other.tasks) {
            this.tasks.add(new Task(task));
        }
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
