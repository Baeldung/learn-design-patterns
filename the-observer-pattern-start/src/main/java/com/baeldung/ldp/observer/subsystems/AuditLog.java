package com.baeldung.ldp.observer.subsystems;

import com.baeldung.ldp.domain.model.Task;
import com.baeldung.ldp.domain.model.TaskStatus;

public class AuditLog {

    public void record(Task task, TaskStatus oldStatus, TaskStatus newStatus) {
        // stub: append to an audit trail
    }
}
