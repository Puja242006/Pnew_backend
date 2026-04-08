package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Issue;
import com.klu.repository.IssueRepository;

@Service
public class IssueService {

    @Autowired
    private IssueRepository repository;

    // GET ALL
    public List<Issue> getAllIssues() {
        return repository.findAll();
    }

    // GET BY ID
    public Issue getIssueById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // CREATE
    public Issue saveIssue(Issue issue) {
        return repository.save(issue);
    }

    // UPDATE
    public Issue updateIssue(Long id, Issue issue) {
        Issue existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setTitle(issue.getTitle());
            existing.setDescription(issue.getDescription());
            existing.setLocation(issue.getLocation());
            existing.setReportedBy(issue.getReportedBy());
            existing.setSeverity(issue.getSeverity());
            existing.setStatus(issue.getStatus());
            existing.setDate(issue.getDate());

            return repository.save(existing);
        }

        return null;
    }

    // DELETE
    public void deleteIssue(Long id) {
        repository.deleteById(id);
    }

    // SEARCH
    public List<Issue> searchIssues(String keyword) {
        return repository.findByTitleContainingIgnoreCase(keyword);
    }

    // FILTER
    public List<Issue> filterBySeverity(String severity) {
        return repository.findBySeverity(severity);
    }
}