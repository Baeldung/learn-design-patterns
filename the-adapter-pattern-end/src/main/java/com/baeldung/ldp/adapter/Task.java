package com.baeldung.ldp.adapter;

public class Task {

    private final String title;
    private final String description;
    private final TaskStatus status;
    private final String sourceId;
    private final String priority;

    public Task(String title, String description, TaskStatus status, String sourceId,
            String priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.sourceId = sourceId;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getPriority() {
        return priority;
    }
}
