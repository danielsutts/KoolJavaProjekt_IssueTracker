package com.koolJavaProjekts.bugTracker.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueController {

    @GetMapping("/issues/all")
    public String allUsers() {
        return "allIssues";
    }
    @GetMapping("/issues/by-ID")
    public String usersByID() {
        return "IssuesByID";
    }
    @PostMapping("/issues/new")
    public String newUser() {
        return "newIssue";
    }
    @DeleteMapping("/issues/issue/delete")
    public String deleteIssue() {
        return "deleteIssue";
    }
}
