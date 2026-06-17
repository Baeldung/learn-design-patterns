package com.baeldung.ldp.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TaskRepository {

    private final Map<Long, Task> tasks = new HashMap<>();
    private long nextId = 1L;

    public Long create(Task task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
        return task.getId();
    }

    public void updateStatus(Long id, TaskStatus newStatus) {
        tasks.get(id).setStatus(newStatus);
    }

    public void assign(Long id, String assignee) {
        tasks.get(id).setAssignee(assignee);
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public void remove(Long id) {
        tasks.remove(id);
    }
}
