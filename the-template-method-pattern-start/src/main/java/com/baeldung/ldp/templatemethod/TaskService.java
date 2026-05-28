package com.baeldung.ldp.templatemethod;

/**
 * Naive baseline that the lesson's Section 2 critiques. Each task type carries the
 * full validate/persist/notify/audit orchestration, with only the per-type step
 * bodies differing. The end project replaces this with the Template Method design.
 */
public class TaskService {

    public TaskResult processEmailTask(Task task) {
        // validate recipient + body
        // persist sent-message record
        // notify recipient via delivery channel
        // audit with recipient + message id
        return new TaskResult(0L, "");
    }

    public TaskResult processReportTask(Task task) {
        // validate date range + dataset
        // persist generated report blob
        // notify subscribers via digest channel
        // audit with report id + row count
        return new TaskResult(0L, "");
    }
}
