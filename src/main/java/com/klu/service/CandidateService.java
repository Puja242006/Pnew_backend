package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Candidate;
import com.klu.repository.CandidateRepository;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository repo;

    // Get all candidates
    public List<Candidate> getAllCandidates() {
        return repo.findAll();
    }

    // Save candidate
    public Candidate saveCandidate(Candidate candidate) {
        return repo.save(candidate);
    }
}