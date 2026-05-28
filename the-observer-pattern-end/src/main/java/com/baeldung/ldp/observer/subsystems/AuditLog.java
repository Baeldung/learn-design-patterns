package com.baeldung.ldp.observer.subsystems;

import java.util.ArrayList;
import java.util.List;

import com.baeldung.ldp.observer.pattern.Observer;
import com.baeldung.ldp.observer.pattern.TaskStatusChangedEvent;

public class AuditLog implements Observer {

    private final List<String> log = new ArrayList<>();

    @Override
    public void onChange(TaskStatusChangedEvent event) {
        log.add("Task " + event.getTask().getId() + ": " + event.getOldStatus() + " -> " + event.getNewStatus());
    }

    public List<String> getLog() {
        return List.copyOf(log);
    }
}
