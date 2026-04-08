package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.PollingLocation;
import com.klu.service.PollingService;

@RestController
@RequestMapping("/api/polling")
@CrossOrigin(origins = "*")
public class PollingController {

    @Autowired
    private PollingService service;

    // 🔥 GET polling location
    @GetMapping("/{userId}")
    public PollingLocation getPolling(@PathVariable Long userId) {
        return service.getPollingLocation(userId);
    }

    // 🔥 ADD polling location
    @PostMapping
    public PollingLocation addPolling(@RequestBody PollingLocation location) {
        return service.saveLocation(location);
    }
}