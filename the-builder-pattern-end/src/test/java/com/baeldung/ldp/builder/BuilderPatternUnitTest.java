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
                .description("Implement the login UI")
                .dueDate(LocalDate.of(2050, 6, 1))
                .status(TaskStatus.IN_PROGRESS)
                .assignee("Alice")
                .build();

        assertEquals("Design login page", task.getName());
        assertEquals(1L, task.getId());
        assertEquals("Implement the login UI", task.getDescription());
        assertEquals(LocalDate.of(2050, 6, 1), task.getDueDate());
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        assertEquals("Alice", task.getAssignee());
    }

    @Test
    void givenOnlyRequiredField_whenBuild_thenDefaultsApplied() {
        Task task = new Task.Builder("Quick task").build();

        assertEquals("Quick task", task.getName());
        assertEquals(TaskStatus.TO_DO, task.getStatus());
        assertNull(task.getId());
        assertNull(task.getDescription());
        assertNull(task.getDueDate());
        assertNull(task.getAssignee());
    }
}
