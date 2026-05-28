package com.baeldung.ldp.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TaskRepository {

    private final Map<Long, Task> tasks = new HashMap<>();
    private long nextId = 1L;

    public Long create(Task task) {
        // TODO: assign next id, store the task, and return its id
        return null;
    }

    public void updateStatus(Long id, TaskStatus newStatus) {
        // TODO: update the status of the task with the given id
    }

    public void assign(Long id, String assignee) {
        // TODO: assign the task with the given id to the given assignee
    }

    public Optional<Task> findById(Long id) {
        // TODO: return the task with the given id, if any
        return Optional.empty();
    }
}
