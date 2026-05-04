package com.baeldung.ldp.strategy;

public class ImportanceBasedPriority implements TaskPriorityStrategy {

    @Override
    public int calculate(Task task) {
        return task.getImportance();
    }
}
