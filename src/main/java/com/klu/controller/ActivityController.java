package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Activity;
import com.klu.service.ActivityService;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin(origins = "*")
public class ActivityController {

    @Autowired
    private ActivityService service;

    @GetMapping
    public List<Activity> getAllActivities() {
        return service.getAllActivities();
    }

    @PostMapping
    public Activity addActivity(@RequestBody Activity activity) {
        return service.saveActivity(activity);
    }
}