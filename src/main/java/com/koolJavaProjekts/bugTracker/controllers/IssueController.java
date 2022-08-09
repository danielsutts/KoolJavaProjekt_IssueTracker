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
import java.util.HashMap;
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
        for (Issue issue : issueRepository.findAll()) {
            issueDto.setIssueName(issue.getIssueName());
            issueDto.setIssueID(issue.getIssueId());
            response.add(issueDto);
        }
        return ResponseEntity.ok(response);
    }

    // This method computes query for given parameters:
    // id, user, name, (priority)
    // Look at query for parameters -> if not, return name, description match
    @GetMapping("/search")
    public ResponseEntity<List<Issue>> getIssue(@RequestParam(value = "id", required = false) String id,
                                                @RequestParam(value = "user", required = false) String user,
                                                @RequestParam(value = "name", required = false) String name) {
        if (id != null || user != null || name != null){
            List<Issue> response = new ArrayList<>();
            final HashMap<String, String> hashIssue = new HashMap<>();
            if (id != null) {
                //TODO make check that ID is Long
                hashIssue.put("id", id);
            }
            if (user != null) {
                hashIssue.put("user", user.toLowerCase());
            }
            if (name != null) {
                hashIssue.put("name", name.toLowerCase());
            }
            for (Issue issue : issueRepository.findAll()) {
                if (issue.getIssueId() == Long.parseLong(hashIssue.get("id")) &&
                        (issue.getAssignee().equals(hashIssue.get("user")) ||
                         issue.getQe().equals(hashIssue.get("user")) ||
                         issue.getSe().equals(hashIssue.get("user")) ||
                         issue.getRequester().equals(hashIssue.get("user")))
//                    issue.getIssueName().equals(hashIssue.get("name"))
                ) {
                    response.add(issue);
                }
            }
            if (!response.isEmpty()) {
                return ResponseEntity.ok(response);
            }
            if (name != null){
                for (Issue issue : issueRepository.findAll()) {
                    if (issue.getDescription().contains(name)) {
                        response.add(issue);
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //TODO SQL-like requests using .findBy() etc.
        /*
         issueName: find all id, user, name -> "user=max@tech,name=FirstIssue"
         a) Find all issues -> check each if has name
         b) Find all issues for user, find all for name, compare (equals)
        */

    @PostMapping("/issues/add")
    public ResponseEntity addIssue(Issue issue) {
        issueRepository.save(issue);
        return (ResponseEntity) ResponseEntity.accepted();
    }

    @PutMapping("/issue")
    public ResponseEntity<String> updateIssue(Issue newIssue) {
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