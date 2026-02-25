package com.baeldung.ldp.singleton;

public enum TaskIdGenerator {

    INSTANCE;

    private long currentId = 0;

    public long nextId() {
        return ++currentId;
    }
}
