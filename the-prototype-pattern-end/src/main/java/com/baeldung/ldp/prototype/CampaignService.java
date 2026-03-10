package com.baeldung.ldp.prototype;

public class CampaignService {

    public Campaign duplicateCampaign(Campaign original) {
        return original.copy();
    }
}
