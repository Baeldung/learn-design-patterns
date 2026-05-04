package com.baeldung.ldp.strategy;

public class EffortWeightedPriority implements TaskPriorityStrategy {

    @Override
    public int calculate(Task task) {
        return task.getImportance() * 10 - task.getEstimatedEffort();
    }
}
