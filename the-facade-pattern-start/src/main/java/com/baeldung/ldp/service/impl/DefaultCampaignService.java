package com.baeldung.ldp.service.impl;

import com.baeldung.ldp.notification.EmailNotifier;
import com.baeldung.ldp.notification.PushNotifier;
import com.baeldung.ldp.notification.SmsNotifier;
import com.baeldung.ldp.service.CampaignService;

public class DefaultCampaignService implements CampaignService {

    @Override
    public void launchCampaign(String message) {
        // Campaign launch logic here...
        EmailNotifier emailNotifier = new EmailNotifier();
        SmsNotifier smsNotifier = new SmsNotifier();
        PushNotifier pushNotifier = new PushNotifier();

        emailNotifier.send(message);
        smsNotifier.send(message);
        pushNotifier.send(message);
    }
}
