package com.baeldung.ldp.factorymethod;

public class PdfExportTask extends Task {

    private String recipient;

    public PdfExportTask(String name) {
        super(name);
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
