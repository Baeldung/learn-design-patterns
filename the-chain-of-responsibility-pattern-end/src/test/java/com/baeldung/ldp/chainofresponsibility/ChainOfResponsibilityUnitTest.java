package com.baeldung.ldp.chainofresponsibility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ChainOfResponsibilityUnitTest {

    @Test
    void givenSmallRequest_whenHandled_thenApprovedByTeamLead() {
        AbstractApprovalHandler chain = new TeamLeadHandler();
        chain.setNext(new ManagerHandler())
          .setNext(new DirectorHandler());
        ApprovalRequest request = new ApprovalRequest(500, "New keyboard");

        chain.handle(request);

        assertEquals("TeamLead", request.getApprovedBy());
    }

    @Test
    void givenMidSizeRequest_whenHandled_thenApprovedByManager() {
        AbstractApprovalHandler chain = new TeamLeadHandler();
        chain.setNext(new ManagerHandler())
          .setNext(new DirectorHandler());
        ApprovalRequest request = new ApprovalRequest(3_000, "Team offsite");

        chain.handle(request);

        assertEquals("Manager", request.getApprovedBy());
    }

    @Test
    void givenLargeRequest_whenHandled_thenApprovedByDirector() {
        AbstractApprovalHandler chain = new TeamLeadHandler();
        chain.setNext(new ManagerHandler())
          .setNext(new DirectorHandler());
        ApprovalRequest request = new ApprovalRequest(15_000, "Conference sponsorship");

        chain.handle(request);

        assertEquals("Director", request.getApprovedBy());
    }

    @Test
    void givenOverLimitRequest_whenHandled_thenApprovedByIsNull() {
        AbstractApprovalHandler chain = new TeamLeadHandler();
        chain.setNext(new ManagerHandler())
          .setNext(new DirectorHandler());
        ApprovalRequest request = new ApprovalRequest(50_000, "Acquisition");

        chain.handle(request);

        assertNull(request.getApprovedBy());
    }

    @Test
    void givenOverLimitRequest_whenDefaultHandlerAppended_thenApprovedByManualReview() {
        AbstractApprovalHandler chain = new TeamLeadHandler();
        chain.setNext(new ManagerHandler())
          .setNext(new DirectorHandler())
          .setNext(new DefaultApprovalHandler());
        ApprovalRequest request = new ApprovalRequest(50_000, "Acquisition");

        chain.handle(request);

        assertEquals("ManualReview", request.getApprovedBy());
    }
}
