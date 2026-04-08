package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klu.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}