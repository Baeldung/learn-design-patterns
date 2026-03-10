package com.baeldung.ldp.builder;

import java.time.LocalDate;

public class Task {

    private final Long id;
    private final String name;
    private final String description;
    private final LocalDate dueDate;
    private final TaskStatus status;
    private final Priority priority;
    private final String assignee;
    private final String project;
    private final Double estimatedHours;

    private Task(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.status = builder.status;
        this.priority = builder.priority;
        this.assignee = builder.assignee;
        this.project = builder.project;
        this.estimatedHours = builder.estimatedHours;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getProject() {
        return project;
    }

    public Double getEstimatedHours() {
        return estimatedHours;
    }

    public static class Builder {

        private Long id;
        private final String name;
        private String description;
        private LocalDate dueDate;
        private TaskStatus status = TaskStatus.TO_DO;
        private Priority priority = Priority.MEDIUM;
        private String assignee;
        private String project;
        private Double estimatedHours;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder status(TaskStatus status) {
            this.status = status;
            return this;
        }

        public Builder priority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder assignee(String assignee) {
            this.assignee = assignee;
            return this;
        }

        public Builder project(String project) {
            this.project = project;
            return this;
        }

        public Builder estimatedHours(Double estimatedHours) {
            this.estimatedHours = estimatedHours;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}
