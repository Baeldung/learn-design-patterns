package com.baeldung.ldp.factorymethod;

public class SimpleTaskFactory {

    public static Task createTask(String type, String name) {
        return switch (type) {
        case "pdf" -> new PdfExportTask(name);
        case "csv" -> new CsvExportTask(name);
        default -> throw new IllegalArgumentException("Unknown task type: " + type);
        };
    }
}
