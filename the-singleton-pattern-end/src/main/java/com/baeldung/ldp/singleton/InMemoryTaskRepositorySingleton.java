package com.baeldung.ldp.singleton;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskRepositorySingleton {

    private static final InMemoryTaskRepositorySingleton INSTANCE = new InMemoryTaskRepositorySingleton();

    private final Map<Long, Task> store = new HashMap<>();

    private InMemoryTaskRepositorySingleton() {
    }

    public static InMemoryTaskRepositorySingleton getInstance() {
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
