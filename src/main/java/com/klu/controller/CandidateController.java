package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Candidate;
import com.klu.service.CandidateService;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin(origins = "*") // 🔥 updated
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return service.getAllCandidates();
    }

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        return service.saveCandidate(candidate);
    }
}