package com.koolJavaProjekts.bugTracker.models;

public class Issue {

    private final long issueId;
    private final String priority;
    private final String issueName;
    private final String description;
    private final String attachment;
    private final Integer buildVersion;
    private final String requester;
    private final String assignee;
    private final Integer dateOpened;
    private final Integer dateUpdated;
    private final Integer dateDue;
    private final Integer buildPoints;
    private final Integer storyPoints;
    private final Integer mrr;
    private final String project;
    private final long childId;
    private final long parentId;
    private final String summary;
    private final String branchName;
    private final String se;
    private final String qe;
    private final String teamLead;
    private final String issue;

    public Issue(long issueId, String priority, String issueName, String description, String attachment, Integer buildVersion, String requester, String assignee, Integer dateOpened, Integer dateUpdated, Integer dateDue, Integer buildPoints, Integer storyPoints, Integer mrr, String project, long childId, long parentId, String summary, String branchName, String se, String qe, String teamLead, String issue) {
        this.issueId = issueId;
        this.priority = priority;
        this.issueName = issueName;
        this.description = description;
        this.attachment = attachment;
        this.buildVersion = buildVersion;
        this.requester = requester;
        this.assignee = assignee;
        this.dateOpened = dateOpened;
        this.dateUpdated = dateUpdated;
        this.dateDue = dateDue;
        this.buildPoints = buildPoints;
        this.storyPoints = storyPoints;
        this.mrr = mrr;
        this.project = project;
        this.childId = childId;
        this.parentId = parentId;
        this.summary = summary;
        this.branchName = branchName;
        this.se = se;
        this.qe = qe;
        this.teamLead = teamLead;
        this.issue = issue;
    }


    public long getIssueId() {
        return issueId;
    }

    public String getPriority() {
        return priority;
    }

    public String getIssueName() {
        return issueName;
    }

    public String getDescription() {
        return description;
    }

    public String getAttachment() {
        return attachment;
    }

    public Integer getBuildVersion() {
        return buildVersion;
    }

    public String getRequester() {
        return requester;
    }

    public String getAssignee() {
        return assignee;
    }

    public Integer getDateOpened() {
        return dateOpened;
    }

    public Integer getDateUpdated() {
        return dateUpdated;
    }

    public Integer getDateDue() {
        return dateDue;
    }

    public Integer getBuildPoints() {
        return buildPoints;
    }

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public Integer getMrr() {
        return mrr;
    }

    public String getProject() {
        return project;
    }

    public long getChildId() {
        return childId;
    }

    public long getParentId() {
        return parentId;
    }

    public String getSummary() {
        return summary;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getSe() {
        return se;
    }

    public String getQe() {
        return qe;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public String getIssue() {
        return issue;
    }

}
