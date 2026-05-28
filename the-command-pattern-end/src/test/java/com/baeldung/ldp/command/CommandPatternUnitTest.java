package com.baeldung.ldp.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CommandPatternUnitTest {

    @Test
    void givenCreateCommand_whenExecuteThenUndo_thenTaskCreatedThenRemoved() {
        TaskRepository repository = new TaskRepository();
        TaskCommandInvoker invoker = new TaskCommandInvoker();
        Task task = new Task("Write docs");
        Command create = new CreateTaskCommand(repository, task);

        invoker.execute(create);
        assertEquals("Write docs", repository.findById(task.getId()).orElseThrow().getName());

        invoker.undo();
        assertTrue(repository.findById(task.getId()).isEmpty());
    }

    @Test
    void givenUpdateStatusCommand_whenExecuteThenUndo_thenStatusChangedThenRestored() {
        TaskRepository repository = new TaskRepository();
        TaskCommandInvoker invoker = new TaskCommandInvoker();
        Task task = new Task("Plan sprint");
        task.setStatus(TaskStatus.TO_DO);
        Long id = repository.create(task);

        invoker.execute(new UpdateTaskStatusCommand(repository, id, TaskStatus.IN_PROGRESS));
        assertEquals(TaskStatus.IN_PROGRESS, repository.findById(id).orElseThrow().getStatus());

        invoker.undo();
        assertEquals(TaskStatus.TO_DO, repository.findById(id).orElseThrow().getStatus());
    }

    @Test
    void givenTwoAssignCommands_whenUndoTwice_thenAssigneeWalksBack() {
        TaskRepository repository = new TaskRepository();
        TaskCommandInvoker invoker = new TaskCommandInvoker();
        Task task = new Task("Deploy build");
        Long id = repository.create(task);

        invoker.execute(new AssignTaskCommand(repository, id, "alice"));
        invoker.execute(new AssignTaskCommand(repository, id, "bob"));
        assertEquals("bob", repository.findById(id).orElseThrow().getAssignee());

        invoker.undo();
        assertEquals("alice", repository.findById(id).orElseThrow().getAssignee());

        invoker.undo();
        assertNull(repository.findById(id).orElseThrow().getAssignee());
    }
}
