package com.baeldung.ldp.service;

import com.baeldung.ldp.domain.model.Task;
import com.baeldung.ldp.domain.model.TaskStatus;
import com.baeldung.ldp.observer.pattern.TaskEventPublisher;
import com.baeldung.ldp.observer.pattern.TaskStatusChangedEvent;

public class TaskService {

    private final TaskEventPublisher publisher;

    public TaskService(TaskEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void changeStatus(Task task, TaskStatus newStatus) {
        TaskStatus oldStatus = task.getStatus();
        if (oldStatus == newStatus) {
            return;
        }
        task.setStatus(newStatus);
        publisher.publish(new TaskStatusChangedEvent(task, oldStatus, newStatus));
    }
}
