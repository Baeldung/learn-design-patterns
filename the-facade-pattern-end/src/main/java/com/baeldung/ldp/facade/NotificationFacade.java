package com.baeldung.ldp.facade;

public class NotificationFacade {

    private final EmailNotifier emailNotifier;
    private final SmsNotifier smsNotifier;
    private final PushNotifier pushNotifier;

    public NotificationFacade() {
        this.emailNotifier = new EmailNotifier();
        this.smsNotifier = new SmsNotifier();
        this.pushNotifier = new PushNotifier();
    }

    public void notify(String message) {
        emailNotifier.send(message);
        smsNotifier.send(message);
        pushNotifier.send(message);
    }
}
