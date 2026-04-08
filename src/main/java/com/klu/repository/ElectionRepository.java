package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.entity.Election;

public interface ElectionRepository extends JpaRepository<Election, Long> {
}