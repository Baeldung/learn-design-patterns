package com.baeldung.ldp.templatemethod;

public class TaskResult {

    private Long recordId;
    private String summary;

    public TaskResult(Long recordId, String summary) {
        this.recordId = recordId;
        this.summary = summary;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
