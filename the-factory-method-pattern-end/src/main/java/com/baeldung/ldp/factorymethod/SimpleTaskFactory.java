package com.baeldung.ldp.factorymethod;

public class SimpleTaskFactory {

    public static Task createTask(String type, String name) {
        return switch (type) {
        case "email" -> new EmailTask(name);
        case "database" -> new DatabaseTask(name);
        default -> throw new IllegalArgumentException("Unknown task type: " + type);
        };
    }
}
