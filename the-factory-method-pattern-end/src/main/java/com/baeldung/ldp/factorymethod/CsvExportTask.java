package com.baeldung.ldp.factorymethod;

public class CsvExportTask extends Task {

    private String query;

    public CsvExportTask(String name) {
        super(name);
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
