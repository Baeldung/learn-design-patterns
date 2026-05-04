package com.baeldung.ldp.strategy;

import java.util.Comparator;
import java.util.List;

public class TaskScheduler {

    private TaskPriorityStrategy strategy;

    public TaskScheduler(TaskPriorityStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TaskPriorityStrategy strategy) {
        this.strategy = strategy;
    }

    public int getPriority(Task task) {
        return strategy.calculate(task);
    }

    public List<Task> prioritize(List<Task> tasks) {
        return tasks.stream().sorted(Comparator.comparingInt(strategy::calculate).reversed()).toList();
    }
}
