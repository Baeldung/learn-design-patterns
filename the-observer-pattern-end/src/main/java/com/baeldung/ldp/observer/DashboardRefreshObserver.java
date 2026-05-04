package com.baeldung.ldp.observer;

public class DashboardRefreshObserver implements Observer {

    private int refreshCount = 0;
    private TaskStatusChangeEvent lastEvent;

    @Override
    public void onStatusChanged(TaskStatusChangeEvent event) {
        refreshCount++;
        lastEvent = event;
    }

    public int getRefreshCount() {
        return refreshCount;
    }

    public TaskStatusChangeEvent getLastEvent() {
        return lastEvent;
    }
}
