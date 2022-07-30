package com.koolJavaProjekts.bugTracker.models;

import javax.persistence.*;

@Entity(name = "issues")

public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long issueId;
    @Column
    private final String priority;
    @Column
    private final String issueName;
    @Column
    private final String description;
    @Column
    private final String attachment;
    @Column
    private final Integer buildVersion;
    @Column
    private final String requester;
    @Column
    private final String assignee;
    @Column
    private final Integer dateOpened;
    @Column
    private final Integer dateUpdated;
    @Column
    private final Integer dateDue;
    @Column
    private final Integer buildPoints;
    @Column
    private final Integer storyPoints;
    @Column
    private final Integer mrr;
    @Column
    private final String project;
    @Column
    private final long childId;
    @Column
    private final long parentId;
    @Column
    private final String summary;
    @Column
    private final String branchName;
    @Column
    private final String se;
    @Column
    private final String qe;
    @Column
    private final String teamLead;
    @Column
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

    public Issue() {
        this.issueId = -1;
        this.priority = "";
        this.issueName = "";
        this.description = "";
        this.attachment = "";
        this.buildVersion = -1;
        this.requester = "";
        this.assignee = "";
        this.dateOpened = -1;
        this.dateUpdated = -1;
        this.dateDue = -1;
        this.buildPoints = -1;
        this.storyPoints = -1;
        this.mrr = -1;
        this.project = "";
        this.childId = -1;
        this.parentId = -1;
        this.summary = "";
        this.branchName = "";
        this.se = "";
        this.qe = "";
        this.teamLead = "";
        this.issue = "";
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
