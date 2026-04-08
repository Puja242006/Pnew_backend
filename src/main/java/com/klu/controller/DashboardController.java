package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Location;
import com.klu.entity.Schedule;
import com.klu.entity.ObserverDashboardDTO;
import com.klu.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private DashboardService service;

    // ✅ STATS
    @GetMapping("/observer")
    public ObserverDashboardDTO getStats(@RequestParam Long userId) {
        return service.getObserverDashboard(userId);
    }

    // ✅ LOCATIONS (IMPORTANT FIX)
    @GetMapping("/observer/locations")
    public List<Location> getLocations(@RequestParam Long userId) {
        return service.getLocations(userId);
    }

    // ✅ SCHEDULE
    @GetMapping("/observer/schedule")
    public List<Schedule> getSchedule(@RequestParam Long userId) {
        return service.getSchedule(userId);
    }
}