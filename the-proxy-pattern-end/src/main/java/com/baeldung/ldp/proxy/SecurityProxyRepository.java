package com.baeldung.ldp.proxy;

import java.util.List;

public class SecurityProxyRepository implements TaskRepository {

    private final TaskRepository realRepository;
    private final UserContext userContext;

    public SecurityProxyRepository(TaskRepository realRepository,
      UserContext userContext) {
        this.realRepository = realRepository;
        this.userContext = userContext;
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
        if (userContext.getRole() != UserRole.ADMIN) {
            throw new SecurityException(
              "Only ADMIN users can delete tasks");
        }
        realRepository.deleteTask(id);
    }
}
