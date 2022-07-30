package com.koolJavaProjekts.bugTracker.repositories;

import com.koolJavaProjekts.bugTracker.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
