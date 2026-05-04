package com.baeldung.ldp.observer;

import java.util.ArrayList;
import java.util.List;

public class AuditLogObserver implements Observer {

    private final List<String> log = new ArrayList<>();

    @Override
    public void onStatusChanged(TaskStatusChangeEvent event) {
        log.add("Task " + event.getTask().getId() + ": " + event.getOldStatus() + " -> " + event.getNewStatus());
    }

    public List<String> getLog() {
        return List.copyOf(log);
    }
}
