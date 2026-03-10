package com.baeldung.ldp.factorymethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

class FactoryMethodPatternUnitTest {

    @Test
    void givenPdfExportTaskCreator_whenCreateTask_thenReturnsPdfExportTask() {
        TaskService service = new TaskService(new PdfExportTaskCreator());

        Task task = service.createTask("Send welcome email");

        assertInstanceOf(PdfExportTask.class, task);
        assertEquals("Send welcome email", task.getName());
    }

    @Test
    void givenCsvExportTaskCreator_whenCreateTask_thenReturnsCsvExportTask() {
        TaskService service = new TaskService(new CsvExportTaskCreator());

        Task task = service.createTask("Run cleanup query");

        assertInstanceOf(CsvExportTask.class, task);
        assertEquals("Run cleanup query", task.getName());
    }
}
