package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Location;
import com.klu.repository.LocationRepository;

@RestController
@RequestMapping("/api/monitoring")
@CrossOrigin("*")
public class MonitoringController {

    @Autowired
    private LocationRepository repo;

    // ✅ GET ALL STATIONS
    @GetMapping("/stations")
    public List<Location> getAllStations() {
        return repo.findAll();
    }
}