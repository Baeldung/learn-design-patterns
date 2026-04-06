package com.baeldung.ldp.facade;

public class CampaignService {

    private final NotificationFacade notificationFacade;

    public CampaignService() {
        this.notificationFacade = new NotificationFacade();
    }

    public void launchCampaign(String message) {
        notificationFacade.notify(message);
    }
}
