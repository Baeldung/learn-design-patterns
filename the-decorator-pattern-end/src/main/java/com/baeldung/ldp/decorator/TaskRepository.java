package com.baeldung.ldp.decorator;

import java.util.List;

public interface TaskRepository {

    void save(Task task);

    List<Task> findAll();
}
