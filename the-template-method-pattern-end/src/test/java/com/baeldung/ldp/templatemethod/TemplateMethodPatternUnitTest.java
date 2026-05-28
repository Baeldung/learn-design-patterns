package com.baeldung.ldp.templatemethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TemplateMethodPatternUnitTest {

    @Test
    void givenEmailTask_whenProcessTask_thenAllStepsRunAndCaptureNamedOutcomes() {
        EmailNotificationTaskProcessor processor = new EmailNotificationTaskProcessor();
        Task task = new Task(1L, TaskType.EMAIL_NOTIFICATION, Map.of(
            "recipient", "alice@example.com",
            "subject", "Welcome",
            "body", "Hello there"));

        TaskResult result = processor.processTask(task);

        String summary = result.getSummary();
        List<String> deliveryChannel = processor.getDeliveryChannel();
        List<String> auditLog = processor.getAuditLog();
        assertNotNull(result.getRecordId());
        assertTrue(summary.contains("alice@example.com"));
        assertTrue(summary.contains("Welcome"));
        assertEquals(1, deliveryChannel.size());
        String deliveryEntry = deliveryChannel.get(0);
        assertTrue(deliveryEntry.contains("alice@example.com"));
        assertEquals(1, auditLog.size());
        String auditEntry = auditLog.get(0);
        assertTrue(auditEntry.contains("alice@example.com"));
    }

    @Test
    void givenReportTask_whenProcessTask_thenAllStepsRunAndCaptureNamedOutcomes() {
        ReportGenerationTaskProcessor processor = new ReportGenerationTaskProcessor();
        Task task = new Task(2L, TaskType.REPORT_GENERATION, Map.of(
            "dataset", "Q3-sales",
            "from", "2050-07-01",
            "to", "2050-09-30",
            "rowCount", 1234));

        TaskResult result = processor.processTask(task);

        String summary = result.getSummary();
        List<String> digestChannel = processor.getDigestChannel();
        List<String> auditLog = processor.getAuditLog();
        assertTrue(summary.contains("Q3-sales"));
        assertTrue(summary.contains("rows=1234"));
        assertEquals(1, digestChannel.size());
        String digestEntry = digestChannel.get(0);
        assertTrue(digestEntry.contains("Q3-sales"));
        assertEquals(1, auditLog.size());
        String auditEntry = auditLog.get(0);
        assertTrue(auditEntry.contains("rows=1234"));
    }

    @Test
    void givenEmailTaskWithBlankRecipient_whenProcessTask_thenThrowsAndDownstreamStepsNotCalled() {
        EmailNotificationTaskProcessor processor = new EmailNotificationTaskProcessor();
        Task task = new Task(3L, TaskType.EMAIL_NOTIFICATION, Map.of(
            "recipient", "",
            "body", "Hello"));

        assertThrows(IllegalArgumentException.class, () -> processor.processTask(task));
        List<String> deliveryChannel = processor.getDeliveryChannel();
        List<String> auditLog = processor.getAuditLog();
        assertTrue(deliveryChannel.isEmpty());
        assertTrue(auditLog.isEmpty());
    }
}
