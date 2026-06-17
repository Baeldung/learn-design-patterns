package com.baeldung.ldp.chainofresponsibility;

public class DirectorHandler extends AbstractApprovalHandler {

    private static final int LIMIT = 20_000;

    @Override
    public void handle(ApprovalRequest request) {
        if (request.getAmount() <= LIMIT) {
            request.setApprovedBy("Director");
        } else {
            passToNext(request);
        }
    }
}
