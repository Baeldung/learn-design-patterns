package com.baeldung.ldp.command;

public class AssignTaskCommand implements Command {

    private final TaskRepository repository;
    private final Long taskId;
    private final String newAssignee;
    private String previousAssignee;

    public AssignTaskCommand(TaskRepository repository, Long taskId, String newAssignee) {
        this.repository = repository;
        this.taskId = taskId;
        this.newAssignee = newAssignee;
    }

    @Override
    public void execute() {
        this.previousAssignee = repository.findById(taskId)
                        .map(Task::getAssignee)
                        .orElse(null);
        repository.assign(taskId, newAssignee);
    }

    @Override
    public void undo() {
        repository.assign(taskId, previousAssignee);
    }
}
