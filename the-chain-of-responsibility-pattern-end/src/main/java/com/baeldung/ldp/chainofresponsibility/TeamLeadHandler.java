package com.baeldung.ldp.chainofresponsibility;

public class TeamLeadHandler extends AbstractApprovalHandler {

    private static final int LIMIT = 1_000;

    @Override
    public void handle(ApprovalRequest request) {
        if (request.getAmount() <= LIMIT) {
            request.setApprovedBy("TeamLead");
        } else {
            passToNext(request);
        }
    }
}
