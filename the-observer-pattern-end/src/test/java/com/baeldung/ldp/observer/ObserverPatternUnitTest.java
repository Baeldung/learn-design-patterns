package com.baeldung.ldp.observer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import org.junit.jupiter.api.Test;

class ObserverPatternUnitTest {

    @Test
    void givenSingleObserver_whenStatusChanges_thenObserverReceivesExactEvent() {
        Task task = new Task(1L, "Write lesson");
        task.setStatus(TaskStatus.TO_DO);
        TaskStatusSubject subject = new TaskStatusSubject(task);
        AuditLogObserver auditLog = new AuditLogObserver();
        subject.register(auditLog);

        subject.setStatus(TaskStatus.IN_PROGRESS);

        assertThat(auditLog.getLog()).containsExactly("Task 1: TO_DO -> IN_PROGRESS");
    }

    @Test
    void givenThreeObservers_whenStatusChangesTwice_thenAllReceiveBothEventsInOrder() {
        Task task = new Task(2L, "Ship feature");
        task.setStatus(TaskStatus.TO_DO);
        TaskStatusSubject subject = new TaskStatusSubject(task);
        AuditLogObserver auditLog = new AuditLogObserver();
        NotificationObserver notifier = new NotificationObserver();
        DashboardRefreshObserver dashboard = new DashboardRefreshObserver();
        subject.register(auditLog);
        subject.register(notifier);
        subject.register(dashboard);

        subject.setStatus(TaskStatus.IN_PROGRESS);
        subject.setStatus(TaskStatus.DONE);

        assertThat(auditLog.getLog()).containsExactly("Task 2: TO_DO -> IN_PROGRESS", "Task 2: IN_PROGRESS -> DONE");
        assertThat(notifier.getOutbox()).extracting(TaskStatusChangeEvent::getOldStatus, TaskStatusChangeEvent::getNewStatus)
                        .containsExactly(tuple(TaskStatus.TO_DO, TaskStatus.IN_PROGRESS), tuple(TaskStatus.IN_PROGRESS, TaskStatus.DONE));
        assertThat(dashboard.getRefreshCount()).isEqualTo(2);
        assertThat(dashboard.getLastEvent().getNewStatus()).isEqualTo(TaskStatus.DONE);
    }

    @Test
    void givenTwoObservers_whenSingleTransition_thenBothReceiveSamePayload() {
        Task task = new Task(3L, "Review PR");
        task.setStatus(TaskStatus.TO_DO);
        TaskStatusSubject subject = new TaskStatusSubject(task);
        AuditLogObserver auditLog = new AuditLogObserver();
        NotificationObserver notifier = new NotificationObserver();
        subject.register(auditLog);
        subject.register(notifier);

        subject.setStatus(TaskStatus.IN_PROGRESS);

        assertThat(auditLog.getLog()).containsExactly("Task 3: TO_DO -> IN_PROGRESS");
        TaskStatusChangeEvent received = notifier.getOutbox().getFirst();
        assertThat(received.getTask().getId()).isEqualTo(3L);
        assertThat(received.getOldStatus()).isEqualTo(TaskStatus.TO_DO);
        assertThat(received.getNewStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
    }

    @Test
    void givenObserverIsUnregistered_whenStatusChangesAgain_thenObserverReceivesNoFurtherEvents() {
        Task task = new Task(4L, "Deploy build");
        task.setStatus(TaskStatus.TO_DO);
        TaskStatusSubject subject = new TaskStatusSubject(task);
        AuditLogObserver auditLog = new AuditLogObserver();
        subject.register(auditLog);

        subject.setStatus(TaskStatus.IN_PROGRESS);
        subject.unregister(auditLog);
        subject.setStatus(TaskStatus.DONE);

        assertThat(auditLog.getLog()).containsExactly("Task 4: TO_DO -> IN_PROGRESS");
    }
}
