package com.baeldung.ldp.singleton;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskRepository {

    private static final InMemoryTaskRepository INSTANCE = new InMemoryTaskRepository();

    private final Map<Long, Task> store = new HashMap<>();

    private InMemoryTaskRepository() {
    }

    public static InMemoryTaskRepository getInstance() {
        return INSTANCE;
    }

    public void save(Long id, Task task) {
        store.put(id, task);
    }

    public Task findById(Long id) {
        return store.get(id);
    }

    public void clear() {
        store.clear();
    }
}
