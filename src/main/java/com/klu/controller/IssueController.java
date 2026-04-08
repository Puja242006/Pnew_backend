package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Issue;
import com.klu.service.IssueService;

@RestController
@RequestMapping("/api/issues")
@CrossOrigin(origins = "*")
public class IssueController {

    @Autowired
    private IssueService service;

    // GET ALL
    @GetMapping
    public List<Issue> getAllIssues() {
        return service.getAllIssues();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Issue getIssue(@PathVariable Long id) {
        return service.getIssueById(id);
    }

    // CREATE
    @PostMapping
    public Issue createIssue(@RequestBody Issue issue) {
        return service.saveIssue(issue);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Issue updateIssue(@PathVariable Long id, @RequestBody Issue issue) {
        return service.updateIssue(id, issue);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteIssue(@PathVariable Long id) {
        service.deleteIssue(id);
        return "Issue deleted successfully";
    }

    // 🔍 SEARCH
    @GetMapping("/search")
    public List<Issue> search(@RequestParam String keyword) {
        return service.searchIssues(keyword);
    }

    // 🔍 FILTER
    @GetMapping("/filter")
    public List<Issue> filter(@RequestParam String severity) {
        return service.filterBySeverity(severity);
    }
}