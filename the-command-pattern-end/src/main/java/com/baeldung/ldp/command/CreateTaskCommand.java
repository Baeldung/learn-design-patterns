package com.baeldung.ldp.command;

public class CreateTaskCommand implements Command {

    private final TaskRepository repository;
    private final Task task;
    private Long createdId;

    public CreateTaskCommand(TaskRepository repository, Task task) {
        this.repository = repository;
        this.task = task;
    }

    @Override
    public void execute() {
        this.createdId = repository.create(task);
    }

    @Override
    public void undo() {
        repository.remove(createdId);
    }
}
