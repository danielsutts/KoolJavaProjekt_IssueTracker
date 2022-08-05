package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.configs.InMemorySessionRegistry;
import com.koolJavaProjekts.bugTracker.dto.IssueDTO;
import com.koolJavaProjekts.bugTracker.models.Issue;
import com.koolJavaProjekts.bugTracker.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    InMemorySessionRegistry sessionRegistry;

    @GetMapping("/all")
    public ResponseEntity<List<IssueDTO>> allIssues(HttpSession session) throws Exception {
        String sessionId = session.getId();
        if (sessionId == null || sessionId.equals("") || sessionRegistry.sessionIsRegistered(sessionId)) {
            throw new Exception("Authentication failed. No key no cookies.");
        }
        List<IssueDTO> response = new ArrayList<>();
        IssueDTO issueDto = new IssueDTO();
        for (Issue issue : issueRepository.findAll()){
            issueDto.setIssueName(issue.getIssueName());
            issueDto.setIssueID(issue.getIssueId());
            response.add(issueDto);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search?{issueName}")
    public ResponseEntity<Issue> getIssue(@PathVariable String issueName){
        for (Issue issue : issueRepository.findAll()){
            if (issue.getIssueName() == issueName){
                return ResponseEntity.ok(issue);
            }
        }
        return (ResponseEntity<Issue>) ResponseEntity.noContent();
    }

    @PostMapping("/issues/add")
    public ResponseEntity addIssue(Issue issue) {
        issueRepository.save(issue);
        return (ResponseEntity) ResponseEntity.accepted();
    }

    @PutMapping("/issue")
    public ResponseEntity<String> updateIssue(Issue newIssue){
        for (Issue issue : issueRepository.findAll()) {
            if (issue.getIssueId() == newIssue.getIssueId()) {
                issue.resetIssue(newIssue);
                return ResponseEntity.ok("Ok");
            }
        }
        return new ResponseEntity<String>("No issue found", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteIssue(Issue deleteIssue) {
        for (Issue issue : issueRepository.findAll()) {
            if (issue.getIssueId() == deleteIssue.getIssueId()) {
                issueRepository.delete(issue);
                return (ResponseEntity) ResponseEntity.accepted();
            }
        }
        return (ResponseEntity) ResponseEntity.badRequest();
    }

}