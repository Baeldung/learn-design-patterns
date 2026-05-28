package com.baeldung.ldp.templatemethod;

public abstract class AbstractTaskProcessor {

    public final TaskResult processTask(Task task) {
        validateTask(task);
        TaskResult result = persistResult(task);
        notifyStakeholders(task, result);
        auditTask(task, result);
        return result;
    }

    protected abstract void validateTask(Task task);

    protected abstract TaskResult persistResult(Task task);

    protected abstract void notifyStakeholders(Task task, TaskResult result);

    protected abstract void auditTask(Task task, TaskResult result);
}
