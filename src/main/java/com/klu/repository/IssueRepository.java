package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    // 🔍 Search by title
    List<Issue> findByTitleContainingIgnoreCase(String keyword);

    // 🔍 Filter by severity
    List<Issue> findBySeverity(String severity);

    // 🔥 DASHBOARD: count issues by user
    int countByUserId(Long userId);
}