package com.baeldung.ldp.factorymethod;

public class TaskService {

    public Task createTask(String type, String name) {
        if ("pdf".equals(type)) {
            return new PdfExportTask(name);
        } else if ("csv".equals(type)) {
            return new CsvExportTask(name);
        }
        throw new IllegalArgumentException("Unknown task type: " + type);
    }
}
