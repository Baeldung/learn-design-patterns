package com.baeldung.ldp.proxy;

import java.util.List;

public interface TaskRepository {

    void save(Task task);

    List<Task> findAll();

    void deleteTask(Long id);
}
