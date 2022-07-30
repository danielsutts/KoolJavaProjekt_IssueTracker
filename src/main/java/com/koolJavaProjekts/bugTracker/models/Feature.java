package com.koolJavaProjekts.bugTracker.models;

public class Feature extends Issue {

    public Feature(long issueId, String priority, String issueName, String description, String attachment, Integer buildVersion, String requester, String assignee, Integer dateOpened, Integer dateUpdated, Integer dateDue, Integer buildPoints, Integer storyPoints, Integer mrr, String project, long childId, long parentId, String summary, String branchName, String se, String qe, String teamLead, String issue) {
        super(issueId, priority, issueName, description, attachment, buildVersion, requester, assignee, dateOpened, dateUpdated, dateDue, buildPoints, storyPoints, mrr, project, childId, parentId, summary, branchName, se, qe, teamLead, issue);
    }
}
