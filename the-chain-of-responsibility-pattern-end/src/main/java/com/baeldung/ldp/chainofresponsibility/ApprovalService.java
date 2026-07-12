package com.baeldung.ldp.chainofresponsibility;

/**
 * Naive baseline that the lesson's Section 2 critiques. Every approval tier, its
 * limit, and their order are hard-coded into one dispatch method. The end project
 * replaces this with the Chain of Responsibility design.
 */
public class ApprovalService {

    private static final int TEAM_LEAD_LIMIT = 1_000;
    private static final int MANAGER_LIMIT = 5_000;
    private static final int DIRECTOR_LIMIT = 20_000;

    public void approve(ApprovalRequest request) {
        if (request.getAmount() <= TEAM_LEAD_LIMIT) {
            request.setApprovedBy("TeamLead");
        } else if (request.getAmount() <= MANAGER_LIMIT) {
            request.setApprovedBy("Manager");
        } else if (request.getAmount() <= DIRECTOR_LIMIT) {
            request.setApprovedBy("Director");
        }
    }
}
