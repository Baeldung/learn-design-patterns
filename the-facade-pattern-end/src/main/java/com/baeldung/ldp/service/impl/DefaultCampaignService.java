package com.baeldung.ldp.service.impl;

import com.baeldung.ldp.notification.NotificationFacade;
import com.baeldung.ldp.service.CampaignService;

public class DefaultCampaignService implements CampaignService {

    private final NotificationFacade notificationFacade;

    public DefaultCampaignService() {
        this.notificationFacade = new NotificationFacade();
    }

    @Override
    public void launchCampaign(String message) {
        // Campaign launch logic here...
        notificationFacade.notify(message);
    }
}
