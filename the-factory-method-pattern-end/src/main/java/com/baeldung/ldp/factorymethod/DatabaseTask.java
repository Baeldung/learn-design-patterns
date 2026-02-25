package com.baeldung.ldp.factorymethod;

public class DatabaseTask extends Task {

    private String query;

    public DatabaseTask(String name) {
        super(name);
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
