package com.baeldung.ldp.templatemethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmailNotificationTaskProcessor extends AbstractTaskProcessor {

    private final List<String> deliveryChannel = new ArrayList<>();
    private final List<String> auditLog = new ArrayList<>();

    @Override
    protected void validateTask(Task task) {
        Map<String, Object> payload = task.getPayload();
        String recipient = (String) payload.get("recipient");
        String body = (String) payload.get("body");
        if (recipient == null || recipient.isBlank() || body == null || body.isBlank()) {
            throw new IllegalArgumentException("Email task requires a recipient and a body");
        }
    }

    @Override
    protected TaskResult persistResult(Task task) {
        Map<String, Object> payload = task.getPayload();
        String recipient = (String) payload.get("recipient");
        String subject = (String) payload.getOrDefault("subject", "(no subject)");
        long recordId = System.nanoTime();
        return new TaskResult(recordId, "sent to " + recipient + " subject=" + subject);
    }

    @Override
    protected void notifyStakeholders(Task task, TaskResult result) {
        Map<String, Object> payload = task.getPayload();
        String recipient = (String) payload.get("recipient");
        deliveryChannel.add("delivered:" + recipient + ":" + result.getRecordId());
    }

    @Override
    protected void auditTask(Task task, TaskResult result) {
        Map<String, Object> payload = task.getPayload();
        String recipient = (String) payload.get("recipient");
        auditLog.add("email:" + recipient + ":" + result.getRecordId());
    }

    public List<String> getDeliveryChannel() {
        return deliveryChannel;
    }

    public List<String> getAuditLog() {
        return auditLog;
    }
}
