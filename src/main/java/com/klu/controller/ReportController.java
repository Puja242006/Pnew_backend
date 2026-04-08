package com.klu.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Report;
import com.klu.service.ReportService;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    @Autowired
    private ReportService service;

    // ✅ GET ALL REPORTS
    @GetMapping
    public List<Report> getAllReports() {
        return service.getAllReports();
    }

    // ✅ GET REPORT BY ID
    @GetMapping("/{id}")
    public Report getReportById(@PathVariable Long id) {
        return service.getReportById(id);
    }

    // 🔥 CREATE REPORT (FIXED FOR DASHBOARD)
    @PostMapping
    public Report addReport(@RequestBody Report report) {

        // 🔥 IMPORTANT: must match dashboard userId
        report.setUserId(2L);

        // 🔥 set current time
        report.setCreatedAt(LocalDateTime.now());

        return service.saveReport(report);
    }

    // ✅ UPDATE REPORT
    @PutMapping("/{id}")
    public Report updateReport(@PathVariable Long id, @RequestBody Report report) {

        // keep existing userId & createdAt
        Report existing = service.getReportById(id);

        report.setUserId(existing.getUserId());
        report.setCreatedAt(existing.getCreatedAt());

        return service.updateReport(id, report);
    }

    // ✅ DELETE REPORT
    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        service.deleteReport(id);
    }
}