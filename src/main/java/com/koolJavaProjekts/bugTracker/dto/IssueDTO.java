package com.koolJavaProjekts.bugTracker.dto;

// TODO dr1mix: match IssueDTO to Issue
public class IssueDTO {
    private String issueName;
    private long issueID;

    public String getIssueName() {
        return issueName;
    }
    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public long getIssueID() {
        return issueID;
    }
    public void setIssueID(long issueID) {
        this.issueID = issueID;
    }
}
