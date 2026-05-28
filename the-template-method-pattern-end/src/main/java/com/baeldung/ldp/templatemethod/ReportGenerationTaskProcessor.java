package com.baeldung.ldp.templatemethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGenerationTaskProcessor extends AbstractTaskProcessor {

    private final List<String> digestChannel = new ArrayList<>();
    private final List<String> auditLog = new ArrayList<>();

    @Override
    protected void validateTask(Task task) {
        Map<String, Object> payload = task.getPayload();
        Object dataset = payload.get("dataset");
        Object from = payload.get("from");
        Object to = payload.get("to");
        if (dataset == null || from == null || to == null) {
            throw new IllegalArgumentException("Report task requires a dataset and a date range");
        }
    }

    @Override
    protected TaskResult persistResult(Task task) {
        Map<String, Object> payload = task.getPayload();
        String dataset = (String) payload.get("dataset");
        int rowCount = (int) payload.getOrDefault("rowCount", 0);
        long reportId = System.nanoTime();
        return new TaskResult(reportId, "report " + dataset + " rows=" + rowCount);
    }

    @Override
    protected void notifyStakeholders(Task task, TaskResult result) {
        Map<String, Object> payload = task.getPayload();
        String dataset = (String) payload.get("dataset");
        digestChannel.add("digest:" + dataset + ":" + result.getRecordId());
    }

    @Override
    protected void auditTask(Task task, TaskResult result) {
        Map<String, Object> payload = task.getPayload();
        Object rowCount = payload.get("rowCount");
        auditLog.add("report:" + result.getRecordId() + ":rows=" + rowCount);
    }

    public List<String> getDigestChannel() {
        return digestChannel;
    }

    public List<String> getAuditLog() {
        return auditLog;
    }
}
