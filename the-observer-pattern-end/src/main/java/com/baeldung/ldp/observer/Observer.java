package com.baeldung.ldp.observer;

public interface Observer {

    void onStatusChanged(TaskStatusChangeEvent event);
}
