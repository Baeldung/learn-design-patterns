package com.baeldung.ldp.factorymethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

class FactoryMethodPatternUnitTest {

    @Test
    void givenPdfExportTaskCreator_whenCreateTask_thenReturnsPdfExportTask() {
        TaskService service = new TaskService(new PdfExportTaskCreator());

        Task task = service.createTask("Generate quarterly report");

        assertInstanceOf(PdfExportTask.class, task);
        assertEquals("Generate quarterly report", task.getName());
    }

    @Test
    void givenCsvExportTaskCreator_whenCreateTask_thenReturnsCsvExportTask() {
        TaskService service = new TaskService(new CsvExportTaskCreator());

        Task task = service.createTask("Export user data");

        assertInstanceOf(CsvExportTask.class, task);
        assertEquals("Export user data", task.getName());
    }
}
