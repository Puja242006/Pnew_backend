package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.entity.PollingLocation;

public interface PollingRepository extends JpaRepository<PollingLocation, Long> {
    PollingLocation findByUserId(Long userId);
}