package com.baeldung.ldp.factorymethod;

public class PdfExportTaskCreator extends TaskCreator {

    @Override
    public Task createTask(String name) {
        return new PdfExportTask(name);
    }
}
