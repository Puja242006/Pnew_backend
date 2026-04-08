package com.klu.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.klu.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {

    int countByUserId(Long userId);

    @Query("SELECT COUNT(r) FROM Report r WHERE r.userId = :userId AND r.createdAt >= :startOfDay")
    int countTodayReports(@Param("userId") Long userId,
                          @Param("startOfDay") LocalDateTime startOfDay);
}