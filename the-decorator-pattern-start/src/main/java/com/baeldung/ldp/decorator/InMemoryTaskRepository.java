package com.baeldung.ldp.decorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskRepository implements TaskRepository {

    private final Map<Long, Task> store = new HashMap<>();

    @Override
    public void save(Task task) {
        store.put(task.getId(), task);
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(store.values());
    }
}
