package com.baeldung.ldp.observer.pattern;

public interface Observer {

    void onChange(TaskStatusChangedEvent event);
}
