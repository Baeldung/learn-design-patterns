package com.baeldung.ldp.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

class StrategyPatternUnitTest {

    @Test
    void givenDeadlineStrategy_whenPrioritize_thenEarliestDueFirst() {
        List<Task> tasks = List.of(
                        new Task("Write docs", LocalDate.now().plusDays(5), 3, 2),
                        new Task("Fix prod bug", LocalDate.now(), 5, 1),
                        new Task("Plan sprint", LocalDate.now().plusDays(2), 4, 3));

        TaskScheduler scheduler = new TaskScheduler(new DeadlineBasedPriority());
        List<Task> prioritized = scheduler.prioritize(tasks);

        assertEquals("Fix prod bug", prioritized.get(0).getName());
        assertEquals("Plan sprint", prioritized.get(1).getName());
        assertEquals("Write docs", prioritized.get(2).getName());
    }

    @Test
    void givenImportanceStrategy_whenPrioritize_thenHighestImportanceFirst() {
        List<Task> tasks = List.of(
                        new Task("Write docs", LocalDate.now().plusDays(5), 3, 2),
                        new Task("Fix prod bug", LocalDate.now(), 5, 1),
                        new Task("Plan sprint", LocalDate.now().plusDays(2), 4, 3));

        TaskScheduler scheduler = new TaskScheduler(new ImportanceBasedPriority());
        List<Task> prioritized = scheduler.prioritize(tasks);

        assertEquals(5, prioritized.get(0).getImportance());
        assertEquals(3, prioritized.get(2).getImportance());
    }

    @Test
    void givenEffortWeightedStrategy_whenPrioritize_thenBlendedOrdering() {
        List<Task> tasks = List.of(
                        new Task("Write docs", LocalDate.now().plusDays(5), 3, 2),
                        new Task("Fix prod bug", LocalDate.now(), 5, 1),
                        new Task("Plan sprint", LocalDate.now().plusDays(2), 4, 3));

        TaskScheduler scheduler = new TaskScheduler(new EffortWeightedPriority());
        List<Task> prioritized = scheduler.prioritize(tasks);

        assertEquals("Fix prod bug", prioritized.get(0).getName());
    }

    @Test
    void givenScheduler_whenStrategyChanged_thenOrderingChanges() {
        List<Task> tasks = List.of(
                        new Task("Write docs", LocalDate.now().plusDays(5), 5, 2),
                        new Task("Fix prod bug", LocalDate.now(), 2, 1),
                        new Task("Plan sprint", LocalDate.now().plusDays(2), 4, 3));

        TaskScheduler scheduler = new TaskScheduler(new DeadlineBasedPriority());
        List<Task> byDeadline = scheduler.prioritize(tasks);

        scheduler.setStrategy(new ImportanceBasedPriority());
        List<Task> byImportance = scheduler.prioritize(tasks);

        assertEquals("Fix prod bug", byDeadline.get(0).getName());
        assertEquals("Write docs", byImportance.get(0).getName());
    }

    @Test
    void givenLambdaStrategy_whenPrioritize_thenOrderingByLambda() {
        List<Task> tasks = List.of(
                        new Task("Write docs", LocalDate.now().plusDays(5), 3, 2),
                        new Task("Fix prod bug", LocalDate.now(), 5, 1),
                        new Task("Plan sprint", LocalDate.now().plusDays(2), 4, 3));

        TaskPriorityStrategy byName = task -> task.getName().length();
        TaskScheduler scheduler = new TaskScheduler(byName);
        List<Task> prioritized = scheduler.prioritize(tasks);

        assertEquals("Fix prod bug", prioritized.get(0).getName());
        assertEquals("Plan sprint", prioritized.get(1).getName());
        assertEquals("Write docs", prioritized.get(2).getName());
    }
}
