package com.baeldung.ldp.observer.pattern;

import java.util.LinkedHashSet;
import java.util.Set;

public class TaskEventPublisher {

    private final Set<Observer> observers = new LinkedHashSet<>();

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void publish(TaskStatusChangedEvent event) {
        for (Observer observer : observers) {
            observer.onChange(event);
        }
    }
}
