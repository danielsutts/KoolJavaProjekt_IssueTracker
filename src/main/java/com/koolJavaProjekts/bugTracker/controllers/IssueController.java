package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.models.Issue;
import com.koolJavaProjekts.bugTracker.repositories.IssueRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IssueController {

    IssueRepository issueRepository;

    @GetMapping("/issues/all")
    public List<Issue> allIssues() {
        return issueRepository.findAll();
    }

    @PostMapping("/issues/add")
    public void addIssue(Issue issue) {
        issueRepository.save(issue);
    }

    @PostMapping
    public void updateIssue(Issue newIssue){
        for (Issue issue : issueRepository.findAll()) {
            if (issue.getIssueId() == newIssue.getIssueId()) {

            }
        }
    }

    @DeleteMapping("/issues/delete")
    public void deleteIssue(Issue deleteIssue) {
        for (Issue issue : issueRepository.findAll()) {
            if (issue.getIssueId() == deleteIssue.getIssueId()) {
                issueRepository.delete(issue);
            }
        }
    }

}