package com.baeldung.ldp.strategy;

import java.time.Duration;
import java.time.LocalDate;

public class TaskScheduler {

    public int calculatePriority(Task task, String mode) {
        return switch (mode) {
        case "deadline" -> (int) -Duration.between(LocalDate.now().atStartOfDay(), task.getDueDate().atStartOfDay()).toDays();
        case "importance" -> task.getImportance();
        case "effort" -> task.getImportance() * 10 - task.getEstimatedEffort();
        default -> 0;
        };
    }
}
