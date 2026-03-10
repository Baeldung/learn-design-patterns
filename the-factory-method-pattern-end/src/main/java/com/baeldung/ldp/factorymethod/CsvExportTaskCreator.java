package com.baeldung.ldp.factorymethod;

public class CsvExportTaskCreator extends TaskCreator {

    @Override
    public Task createTask(String name) {
        return new CsvExportTask(name);
    }
}
