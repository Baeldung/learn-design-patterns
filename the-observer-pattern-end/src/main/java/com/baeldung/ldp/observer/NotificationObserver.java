package com.baeldung.ldp.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationObserver implements Observer {

    private final List<TaskStatusChangeEvent> outbox = new ArrayList<>();

    @Override
    public void onStatusChanged(TaskStatusChangeEvent event) {
        outbox.add(event);
    }

    public List<TaskStatusChangeEvent> getOutbox() {
        return List.copyOf(outbox);
    }
}
