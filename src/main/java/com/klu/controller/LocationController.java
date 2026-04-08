package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Location;
import com.klu.repository.LocationRepository;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private LocationRepository locationRepo;

    // ✅ ADD LOCATION
    @PostMapping
    public Location addLocation(@RequestBody Location location) {
        return locationRepo.save(location);
    }

    // ✅ GET ALL
    @GetMapping
    public Object getAll() {
        return locationRepo.findAll();
    }
}