package com.baeldung.ldp.facade;

public class CampaignService {

    public void launchCampaign(String message) {
        EmailNotifier emailNotifier = new EmailNotifier();
        SmsNotifier smsNotifier = new SmsNotifier();
        PushNotifier pushNotifier = new PushNotifier();

        emailNotifier.send(message);
        smsNotifier.send(message);
        pushNotifier.send(message);
    }
}
