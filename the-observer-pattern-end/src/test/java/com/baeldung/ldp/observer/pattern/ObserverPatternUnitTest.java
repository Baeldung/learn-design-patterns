package com.baeldung.ldp.observer.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.baeldung.ldp.domain.model.Task;
import com.baeldung.ldp.domain.model.TaskStatus;
import com.baeldung.ldp.observer.subsystems.AuditLog;
import com.baeldung.ldp.observer.subsystems.Dashboard;
import com.baeldung.ldp.observer.subsystems.NotificationSender;
import com.baeldung.ldp.service.TaskService;

class ObserverPatternUnitTest {

    @Test
    void givenAllObserversRegistered_whenStatusChanges_thenEachReceivesCorrectEvent() {
        Task task = new Task(1L, "Write lesson");
        task.setStatus(TaskStatus.TO_DO);
        TaskEventPublisher publisher = new TaskEventPublisher();
        AuditLog auditLog = new AuditLog();
        NotificationSender notifications = new NotificationSender();
        Dashboard dashboard = new Dashboard();
        publisher.register(auditLog);
        publisher.register(notifications);
        publisher.register(dashboard);
        TaskService taskService = new TaskService(publisher);

        taskService.changeStatus(task, TaskStatus.IN_PROGRESS);

        assertEquals(List.of("Task 1: TO_DO -> IN_PROGRESS"), auditLog.getLog());
        assertEquals(1, notifications.getOutbox().size());
        TaskStatusChangedEvent received = notifications.getOutbox().get(0);
        assertSame(task, received.getTask());
        assertEquals(TaskStatus.TO_DO, received.getOldStatus());
        assertEquals(TaskStatus.IN_PROGRESS, received.getNewStatus());
        assertEquals(1, dashboard.getRefreshCount());
        assertEquals(TaskStatus.IN_PROGRESS, dashboard.getLastEvent().getNewStatus());
    }

    @Test
    void givenObserverIsUnregistered_whenStatusChangesAgain_thenObserverReceivesNoFurtherEvents() {
        Task task = new Task(4L, "Deploy build");
        task.setStatus(TaskStatus.TO_DO);
        TaskEventPublisher publisher = new TaskEventPublisher();
        AuditLog auditLog = new AuditLog();
        publisher.register(auditLog);
        TaskService taskService = new TaskService(publisher);

        taskService.changeStatus(task, TaskStatus.IN_PROGRESS);
        publisher.unregister(auditLog);
        taskService.changeStatus(task, TaskStatus.DONE);

        assertEquals(List.of("Task 4: TO_DO -> IN_PROGRESS"), auditLog.getLog());
    }
}
