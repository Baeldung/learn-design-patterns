package com.baeldung.ldp.command;

public class UpdateTaskStatusCommand implements Command {

    private final TaskRepository repository;
    private final Long taskId;
    private final TaskStatus newStatus;
    private TaskStatus previousStatus;

    public UpdateTaskStatusCommand(TaskRepository repository, Long taskId, TaskStatus newStatus) {
        this.repository = repository;
        this.taskId = taskId;
        this.newStatus = newStatus;
    }

    @Override
    public void execute() {
        this.previousStatus = repository.findById(taskId)
                        .map(Task::getStatus)
                        .orElseThrow();
        repository.updateStatus(taskId, newStatus);
    }

    @Override
    public void undo() {
        repository.updateStatus(taskId, previousStatus);
    }
}
