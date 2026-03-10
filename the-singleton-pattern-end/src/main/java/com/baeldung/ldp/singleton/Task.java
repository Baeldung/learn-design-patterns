package com.baeldung.ldp.singleton;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", status=" + status + "]";
    }
}
