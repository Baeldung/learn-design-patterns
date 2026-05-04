package com.baeldung.ldp.strategy;

import java.time.LocalDate;

public class Task {

    private final String name;
    private final LocalDate dueDate;
    private final int importance;
    private final int estimatedEffort;

    public Task(String name, LocalDate dueDate, int importance, int estimatedEffort) {
        this.name = name;
        this.dueDate = dueDate;
        this.importance = importance;
        this.estimatedEffort = estimatedEffort;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getImportance() {
        return importance;
    }

    public int getEstimatedEffort() {
        return estimatedEffort;
    }
}
