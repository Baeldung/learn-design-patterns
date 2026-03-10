package com.baeldung.ldp.singleton;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskRepository {

    private final Map<Long, Task> store = new HashMap<>();

    public InMemoryTaskRepository() {
    }

    public void save(Long id, Task task) {
        store.put(id, task);
    }

    public Task findById(Long id) {
        return store.get(id);
    }
}
