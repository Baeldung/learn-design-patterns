package com.baeldung.ldp.templatemethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TemplateMethodPatternUnitTest {

    private static class TrackingTaskProcessor extends AbstractTaskProcessor {
        final List<String> executionOrder = new ArrayList<>();

        @Override
        protected void validateTask(Task task) {
            executionOrder.add("validate");
        }

        @Override
        protected TaskResult persistResult(Task task) {
            executionOrder.add("persist");
            return new TaskResult(1L, "tracking");
        }

        @Override
        protected void notifyStakeholders(Task task, TaskResult result) {
            executionOrder.add("notify");
        }

        @Override
        protected void auditTask(Task task, TaskResult result) {
            executionOrder.add("audit");
        }
    }

    @Test
    void givenAnyTask_whenProcessTask_thenStepsRunInFixedOrder() {
        TrackingTaskProcessor processor = new TrackingTaskProcessor();
        Task task = new Task(
            1L,
            TaskType.EMAIL_NOTIFICATION,
            Map.of("recipient", "alice@example.com", "body", "Hello")
        );

        processor.processTask(task);

        assertEquals(
            List.of("validate", "persist", "notify", "audit"),
            processor.executionOrder
        );
    }

    @Test
    void givenValidationFails_whenProcessTask_thenOnlyValidationRuns() {
        List<String> executionOrder = new ArrayList<>();
        AbstractTaskProcessor processor = new AbstractTaskProcessor() {
            @Override
            protected void validateTask(Task task) {
                executionOrder.add("validate");
                throw new IllegalArgumentException("invalid task");
            }

            @Override
            protected TaskResult persistResult(Task task) {
                executionOrder.add("persist");
                return new TaskResult(1L, "tracking");
            }

            @Override
            protected void notifyStakeholders(Task task, TaskResult result) {
                executionOrder.add("notify");
            }

            @Override
            protected void auditTask(Task task, TaskResult result) {
                executionOrder.add("audit");
            }
        };

        assertThrows(
            IllegalArgumentException.class,
            () -> processor.processTask(new Task(2L, TaskType.EMAIL_NOTIFICATION, Map.of()))
        );
        assertEquals(List.of("validate"), executionOrder);
    }
}
