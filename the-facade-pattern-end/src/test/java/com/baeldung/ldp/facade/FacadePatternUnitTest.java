package com.baeldung.ldp.facade;

import org.junit.jupiter.api.Test;

class FacadePatternUnitTest {

    @Test
    void whenLaunchingCampaign_thenAllChannelsNotified() {
        CampaignService campaignService = new CampaignService();

        campaignService.launchCampaign("Campaign launched");
    }
}
