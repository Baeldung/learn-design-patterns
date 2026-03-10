package com.baeldung.ldp.singleton;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskRepositorySingletonDCL {

    private static volatile InMemoryTaskRepositorySingletonDCL instance;

    private final Map<Long, Task> store = new HashMap<>();

    private InMemoryTaskRepositorySingletonDCL() {
    }

    public static InMemoryTaskRepositorySingletonDCL getInstance() {
        if (instance == null) {
            synchronized (InMemoryTaskRepositorySingletonDCL.class) {
                if (instance == null) {
                    instance = new InMemoryTaskRepositorySingletonDCL();
                }
            }
        }
        return instance;
    }

    public void save(Long id, Task task) {
        store.put(id, task);
    }

    public Task findById(Long id) {
        return store.get(id);
    }
}
