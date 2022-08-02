package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.configs.InMemorySessionRegistry;
import com.koolJavaProjekts.bugTracker.models.Issue;
import com.koolJavaProjekts.bugTracker.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.RequestAttributeAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class IssueController {
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    InMemorySessionRegistry sessionRegistry;

    @GetMapping("/issues/all")
    public List<Issue> allIssues(HttpSession session) throws Exception {
        String sessionId = session.getId();
        if (sessionId == null || sessionId.equals("") || sessionRegistry.sessionIsRegistered(sessionId)) {
            throw new Exception("Authentication failed. No key no cookies.");
        }
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