package com.koolJavaProjekts.bugTracker.dto;

import com.koolJavaProjekts.bugTracker.models.Issue;

import javax.persistence.Column;

public class IssueDTO {
    private String issueName;
    private String priority;
    private long issueID;
    private String description;
    private String attachment;
    private Integer buildVersion;
    private String requester;
    private String assignee;
    private Integer dateOpened;
    private Integer dateUpdated;
    private Integer dateDue;
    private Integer buildPoints;
    private Integer storyPoints;
    private Integer mrr;
    private String project;
    private long childId;
    private long parentId;
    private String summary;
    private String branchName;
    private String se;
    private String qe;
    private String teamLead;
    private String issue;

    public String getIssueName() {
        return issueName;
    }
    public String getPriority() {
        return priority;
    }

    public long getIssueID() {
        return issueID;
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

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setIssueID(long issueID) {
        this.issueID = issueID;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
    public void setBuildVersion(Integer buildVersion) {
        this.buildVersion = buildVersion;
    }
    public void setRequester(String requester) {
        this.requester = requester;
    }
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
    public void setDateOpened(Integer dateOpened) {
        this.dateOpened = dateOpened;
    }
    public void setDateUpdated(Integer dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
    public void setDateDue(Integer dateDue) {
        this.dateDue = dateDue;
    }
    public void setBuildPoints(Integer buildPoints) {
        this.buildPoints = buildPoints;
    }
    public void setStoryPoints(Integer storyPoints) {
        this.storyPoints = storyPoints;
    }
    public void setMrr(Integer mrr) {
        this.mrr = mrr;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public void setChildId(long childId) {
        this.childId = childId;
    }
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    public void setSe(String se) {
        this.se = se;
    }
    public void setQe(String qe) {
        this.qe = qe;
    }
    public void setTeamLead(String teamLead) {
        this.teamLead = teamLead;
    }
    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void fromIssue(Issue issue) {
        this.issueName = issue.getIssueName();
        this.priority = issue.getPriority();
        this.issueID = issue.getIssueId();
        this.description = issue.getDescription();
        this.attachment = issue.getAttachment();
        this.buildVersion = issue.getBuildVersion();
        this.requester = issue.getRequester();
        this.assignee = issue.getAssignee();
        this.dateOpened = issue.getDateOpened();
        this.dateUpdated = issue.getDateUpdated();
        this.dateDue = issue.getDateDue();
        this.buildPoints = issue.getBuildPoints();
        this.storyPoints = issue.getStoryPoints();
        this.mrr = issue.getMrr();
        this.project = issue.getProject();
        this.childId = issue.getChildId();
        this.parentId = issue.getParentId();
        this.summary = issue.getSummary();
        this.branchName = issue.getBranchName();
        this.se = issue.getSe();
        this.qe = issue.getQe();
        this.teamLead = issue.getTeamLead();
        this.issue = issue.getIssue();
    }
}