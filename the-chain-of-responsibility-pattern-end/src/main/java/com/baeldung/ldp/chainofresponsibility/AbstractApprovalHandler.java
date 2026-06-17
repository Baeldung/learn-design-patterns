package com.baeldung.ldp.chainofresponsibility;

public abstract class AbstractApprovalHandler {

    protected AbstractApprovalHandler next;

    public AbstractApprovalHandler setNext(AbstractApprovalHandler next) {
        this.next = next;
        return next;
    }

    protected void passToNext(ApprovalRequest request) {
        if (next != null) {
            next.handle(request);
        }
    }

    public abstract void handle(ApprovalRequest request);
}
