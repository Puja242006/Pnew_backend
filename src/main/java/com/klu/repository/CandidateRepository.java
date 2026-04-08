package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}