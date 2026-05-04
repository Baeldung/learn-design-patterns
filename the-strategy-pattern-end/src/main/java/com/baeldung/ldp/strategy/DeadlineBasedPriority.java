package com.baeldung.ldp.strategy;

import java.time.Duration;
import java.time.LocalDate;

public class DeadlineBasedPriority implements TaskPriorityStrategy {

    @Override
    public int calculate(Task task) {
        return (int) -Duration.between(LocalDate.now().atStartOfDay(), task.getDueDate().atStartOfDay()).toDays();
    }
}
