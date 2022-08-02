package com.koolJavaProjekts.bugTracker.controllers;

import com.koolJavaProjekts.bugTracker.models.Issue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    /*
    Either perfect match, or substring match
     */
    @GetMapping("/search?" + issue_name)
    public ResponseEntity<Issue> searchResult(String search) {
        return ResponseEntity.ok(resultIssues);
    }
}
