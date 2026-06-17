package com.baeldung.ldp.chainofresponsibility;

public class DefaultApprovalHandler extends AbstractApprovalHandler {

    @Override
    public void handle(ApprovalRequest request) {
        request.setApprovedBy("ManualReview");
    }
}
