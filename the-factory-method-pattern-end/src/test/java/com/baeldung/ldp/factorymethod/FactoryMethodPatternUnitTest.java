package com.baeldung.ldp.factorymethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

class FactoryMethodPatternUnitTest {

    @Test
    void givenEmailTaskCreator_whenCreateTask_thenReturnsEmailTask() {
        TaskService service = new TaskService(new EmailTaskCreator());

        Task task = service.createTask("Send welcome email");

        assertInstanceOf(EmailTask.class, task);
        assertEquals("Send welcome email", task.getName());
    }

    @Test
    void givenDatabaseTaskCreator_whenCreateTask_thenReturnsDatabaseTask() {
        TaskService service = new TaskService(new DatabaseTaskCreator());

        Task task = service.createTask("Run cleanup query");

        assertInstanceOf(DatabaseTask.class, task);
        assertEquals("Run cleanup query", task.getName());
    }
}
