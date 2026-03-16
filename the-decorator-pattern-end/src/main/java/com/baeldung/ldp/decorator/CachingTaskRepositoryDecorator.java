package com.baeldung.ldp.decorator;

import java.util.List;

public class CachingTaskRepositoryDecorator implements TaskRepository {

    private final TaskRepository wrapped;
    private List<Task> cache;

    public CachingTaskRepositoryDecorator(TaskRepository wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void save(Task task) {
        wrapped.save(task);
        cache = null;
    }

    @Override
    public List<Task> findAll() {
        if (cache == null) {
            cache = wrapped.findAll();
        }
        return cache;
    }
}
