package com.baeldung.ldp.templatemethod;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTaskProcessor {

    private final List<String> notifications = new ArrayList<>();

    public final TaskResult processTask(Task task) {
        validateTask(task);
        TaskResult result = persistResult(task);
        notifyStakeholders(task, result);
        auditTask(task, result);
        return result;
    }

    protected abstract void validateTask(Task task);

    protected abstract TaskResult persistResult(Task task);

    protected void notifyStakeholders(Task task, TaskResult result) {
        notifications.add("notified:" + result.getRecordId() + ":" + result.getSummary());
    }

    protected abstract void auditTask(Task task, TaskResult result);

    public List<String> getNotifications() {
        return notifications;
    }
}
