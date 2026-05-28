package com.baeldung.ldp.observer.subsystems;

import java.util.ArrayList;
import java.util.List;

import com.baeldung.ldp.observer.pattern.Observer;
import com.baeldung.ldp.observer.pattern.TaskStatusChangedEvent;

public class NotificationSender implements Observer {

    private final List<TaskStatusChangedEvent> outbox = new ArrayList<>();

    @Override
    public void onChange(TaskStatusChangedEvent event) {
        outbox.add(event);
    }

    public List<TaskStatusChangedEvent> getOutbox() {
        return List.copyOf(outbox);
    }
}
