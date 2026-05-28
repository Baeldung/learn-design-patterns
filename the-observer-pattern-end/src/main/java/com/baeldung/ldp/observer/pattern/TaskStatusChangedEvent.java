package com.baeldung.ldp.observer.pattern;

import com.baeldung.ldp.domain.model.Task;
import com.baeldung.ldp.domain.model.TaskStatus;

public class TaskStatusChangedEvent {

    private final Task task;
    private final TaskStatus oldStatus;
    private final TaskStatus newStatus;

    public TaskStatusChangedEvent(Task task, TaskStatus oldStatus, TaskStatus newStatus) {
        this.task = task;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public Task getTask() {
        return task;
    }

    public TaskStatus getOldStatus() {
        return oldStatus;
    }

    public TaskStatus getNewStatus() {
        return newStatus;
    }
}
