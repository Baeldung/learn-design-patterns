package com.baeldung.ldp.proxy;

import java.util.List;

public class SecurityProxyRepository implements TaskRepository {

    private final TaskRepository realRepository;

    public SecurityProxyRepository(TaskRepository realRepository) {
        this.realRepository = realRepository;
    }

    @Override
    public void save(Task task) {
        realRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return realRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        if (UserContextHolder.getRole() != UserRole.ADMIN) {
            throw new SecurityException("Only ADMIN users can delete tasks");
        }
        realRepository.deleteTask(id);
    }
}
