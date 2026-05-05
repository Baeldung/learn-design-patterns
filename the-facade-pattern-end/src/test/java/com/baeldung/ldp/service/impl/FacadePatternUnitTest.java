package com.baeldung.ldp.service.impl;

import org.junit.jupiter.api.Test;

import com.baeldung.ldp.service.CampaignService;

class FacadePatternUnitTest {

    @Test
    void whenLaunchingCampaign_thenAllChannelsNotified() {
        CampaignService campaignService = new DefaultCampaignService();

        campaignService.launchCampaign("Campaign launched");
    }
}
