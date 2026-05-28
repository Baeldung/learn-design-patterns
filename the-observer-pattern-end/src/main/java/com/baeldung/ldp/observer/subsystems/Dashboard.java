package com.baeldung.ldp.observer.subsystems;

import com.baeldung.ldp.observer.pattern.Observer;
import com.baeldung.ldp.observer.pattern.TaskStatusChangedEvent;

public class Dashboard implements Observer {

    private int refreshCount = 0;
    private TaskStatusChangedEvent lastEvent;

    @Override
    public void onChange(TaskStatusChangedEvent event) {
        refreshCount++;
        lastEvent = event;
    }

    public int getRefreshCount() {
        return refreshCount;
    }

    public TaskStatusChangedEvent getLastEvent() {
        return lastEvent;
    }
}
