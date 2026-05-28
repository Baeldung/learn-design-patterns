package com.baeldung.ldp.service;

import com.baeldung.ldp.domain.model.Task;
import com.baeldung.ldp.domain.model.TaskStatus;
import com.baeldung.ldp.observer.subsystems.AuditLog;
import com.baeldung.ldp.observer.subsystems.Dashboard;
import com.baeldung.ldp.observer.subsystems.NotificationSender;

public class TaskService {

    private final AuditLog auditLog;
    private final NotificationSender notifications;
    private final Dashboard dashboard;

    public TaskService(AuditLog auditLog, NotificationSender notifications, Dashboard dashboard) {
        this.auditLog = auditLog;
        this.notifications = notifications;
        this.dashboard = dashboard;
    }

    public void changeStatus(Task task, TaskStatus newStatus) {
        TaskStatus oldStatus = task.getStatus();
        task.setStatus(newStatus);

        auditLog.record(task, oldStatus, newStatus);
        notifications.send(task, newStatus);
        dashboard.refresh();
    }
}
