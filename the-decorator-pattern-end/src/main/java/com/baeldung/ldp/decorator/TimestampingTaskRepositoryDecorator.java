package com.baeldung.ldp.decorator;

import java.time.LocalDateTime;
import java.util.List;

public class TimestampingTaskRepositoryDecorator implements TaskRepository {

    private final TaskRepository wrapped;

    public TimestampingTaskRepositoryDecorator(TaskRepository wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void save(Task task) {
        if (task.getCreatedAt() == null) {
            task.setCreatedAt(LocalDateTime.now());
        }
        task.setUpdatedAt(LocalDateTime.now());
        wrapped.save(task);
    }

    @Override
    public List<Task> findAll() {
        return wrapped.findAll();
    }
}
