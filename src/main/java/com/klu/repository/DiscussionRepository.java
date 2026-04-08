package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.entity.Discussion;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
}