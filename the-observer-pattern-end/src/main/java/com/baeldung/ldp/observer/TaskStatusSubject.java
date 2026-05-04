package com.baeldung.ldp.observer;

import java.util.LinkedHashSet;
import java.util.Set;

public class TaskStatusSubject {

    private final Task task;
    private final Set<Observer> observers = new LinkedHashSet<>();

    public TaskStatusSubject(Task task) {
        this.task = task;
    }

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void setStatus(TaskStatus newStatus) {
        TaskStatus oldStatus = task.getStatus();
        if (oldStatus == newStatus) {
            return;
        }
        task.setStatus(newStatus);
        TaskStatusChangeEvent event = new TaskStatusChangeEvent(task, oldStatus, newStatus);
        notifyObservers(event);
    }

    private void notifyObservers(TaskStatusChangeEvent event) {
        for (Observer observer : observers) {
            observer.onStatusChanged(event);
        }
    }
}
