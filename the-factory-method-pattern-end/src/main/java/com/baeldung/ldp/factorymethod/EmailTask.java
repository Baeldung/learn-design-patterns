package com.baeldung.ldp.factorymethod;

public class EmailTask extends Task {

    private String recipient;

    public EmailTask(String name) {
        super(name);
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
