package com.klu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.ObserverDashboardDTO;
import com.klu.entity.Location;
import com.klu.entity.Schedule;
import com.klu.repository.ReportRepository;
import com.klu.repository.IssueRepository;
import com.klu.repository.LocationRepository;
import com.klu.repository.ScheduleRepository;

@Service
public class DashboardService {

    @Autowired
    private ReportRepository reportRepo;

    @Autowired
    private IssueRepository issueRepo;

    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private ScheduleRepository scheduleRepo;

    // ✅ STATS
    public ObserverDashboardDTO getObserverDashboard(Long userId) {

        int assignedLocations = locationRepo.countByObserverId(userId);
        int reportsSubmitted = reportRepo.countByUserId(userId);

        LocalDateTime todayStart = LocalDateTime.now()
                .toLocalDate()
                .atStartOfDay();

        int observationsToday = reportRepo.countTodayReports(userId, todayStart);
        int irregularities = issueRepo.countByUserId(userId);

        return new ObserverDashboardDTO(
                assignedLocations,
                observationsToday,
                reportsSubmitted,
                irregularities
        );
    }

    // ✅ LOCATIONS
    public List<Location> getLocations(Long userId) {
        return locationRepo.findByObserverId(userId);
    }

    // ✅ SCHEDULE
    public List<Schedule> getSchedule(Long userId) {
        return scheduleRepo.findByObserverId(userId);
    }
}