package com.koolJavaProjekts.bugTracker.models;

import javax.persistence.*;

@Entity(name = "issues")

public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long issueId;
    @Column
    private String priority;
    @Column
    private String issueName;
    @Column
    private String description;
    @Column
    private String attachment;
    @Column
    private Integer buildVersion;
    @Column
    private String requester;
    @Column
    private String assignee;
    @Column
    private Integer dateOpened;
    @Column
    private Integer dateUpdated;
    @Column
    private Integer dateDue;
    @Column
    private Integer buildPoints;
    @Column
    private Integer storyPoints;
    @Column
    private Integer mrr;
    @Column
    private String project;
    @Column
    private long childId;
    @Column
    private long parentId;
    @Column
    private String summary;
    @Column
    private String branchName;
    @Column
    private String se;
    @Column
    private String qe;
    @Column
    private String teamLead;
    @Column
    private String issue;


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

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
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
}
