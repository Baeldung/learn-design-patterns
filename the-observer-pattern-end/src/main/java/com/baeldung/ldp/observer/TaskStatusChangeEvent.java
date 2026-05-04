package com.baeldung.ldp.observer;

public class TaskStatusChangeEvent {

    private final Task task;
    private final TaskStatus oldStatus;
    private final TaskStatus newStatus;

    public TaskStatusChangeEvent(Task task, TaskStatus oldStatus, TaskStatus newStatus) {
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
