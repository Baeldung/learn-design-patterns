package com.baeldung.ldp.chainofresponsibility;

public class ManagerHandler extends AbstractApprovalHandler {

    private static final int LIMIT = 5_000;

    @Override
    public void handle(ApprovalRequest request) {
        if (request.getAmount() <= LIMIT) {
            request.setApprovedBy("Manager");
        } else {
            passToNext(request);
        }
    }
}
