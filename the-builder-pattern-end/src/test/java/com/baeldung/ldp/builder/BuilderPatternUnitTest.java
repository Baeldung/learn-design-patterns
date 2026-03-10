package com.baeldung.ldp.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class BuilderPatternUnitTest {

    @Test
    void givenAllFieldsSet_whenBuild_thenTaskHasAllValues() {
        Task task = new Task.Builder("Design login page")
                .id(1L)
                .description("Create wireframes and implement the login UI with OAuth support")
                .dueDate(LocalDate.of(2050, 6, 1))
                .status(TaskStatus.IN_PROGRESS)
                .priority(Priority.HIGH)
                .assignee("Alice")
                .project("Website Redesign")
                .estimatedHours(12.0)
                .build();

        assertEquals("Design login page", task.getName());
        assertEquals(1L, task.getId());
        assertEquals("Create wireframes and implement the login UI with OAuth support", task.getDescription());
        assertEquals(LocalDate.of(2050, 6, 1), task.getDueDate());
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        assertEquals(Priority.HIGH, task.getPriority());
        assertEquals("Alice", task.getAssignee());
        assertEquals("Website Redesign", task.getProject());
        assertEquals(12.0, task.getEstimatedHours());
    }

    @Test
    void givenOnlyRequiredField_whenBuild_thenDefaultsApplied() {
        Task task = new Task.Builder("Quick task").build();

        assertEquals("Quick task", task.getName());
        assertEquals(TaskStatus.TO_DO, task.getStatus());
        assertEquals(Priority.MEDIUM, task.getPriority());
        assertNull(task.getId());
        assertNull(task.getDescription());
        assertNull(task.getDueDate());
        assertNull(task.getAssignee());
        assertNull(task.getProject());
        assertNull(task.getEstimatedHours());
    }
}
