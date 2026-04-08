package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.NotificationSettings;
import com.klu.service.NotificationSettingsService;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin(origins = "*")
public class NotificationSettingsController {

    @Autowired
    private NotificationSettingsService service;

    // GET SETTINGS
    @GetMapping("/{userId}")
    public NotificationSettings getSettings(@PathVariable Long userId) {
        return service.getSettings(userId);
    }

    // UPDATE SETTINGS
    @PutMapping
    public NotificationSettings updateSettings(@RequestBody NotificationSettings settings) {
        return service.saveSettings(settings);
    }
}