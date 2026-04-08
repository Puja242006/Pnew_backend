package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Report;
import com.klu.repository.ReportRepository;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository;

    // ✅ GET ALL REPORTS
    public List<Report> getAllReports() {
        return repository.findAll();
    }

    // ✅ GET REPORT BY ID
    public Report getReportById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ✅ CREATE REPORT
    public Report saveReport(Report report) {
        return repository.save(report);
    }

    // ✅ UPDATE REPORT
    public Report updateReport(Long id, Report updatedReport) {
        Report report = repository.findById(id).orElse(null);

        if (report != null) {
            report.setTitle(updatedReport.getTitle());
            report.setDescription(updatedReport.getDescription());
            report.setStatus(updatedReport.getStatus());
            return repository.save(report);
        }

        return null;
    }

    // ✅ DELETE REPORT
    public void deleteReport(Long id) {
        repository.deleteById(id);
    }
}