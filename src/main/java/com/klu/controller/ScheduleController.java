package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Schedule;
import com.klu.repository.ScheduleRepository;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin("*")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepo;

    // ✅ ADD SCHEDULE
    @PostMapping
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        return scheduleRepo.save(schedule);
    }

    // ✅ GET ALL
    @GetMapping
    public Object getAll() {
        return scheduleRepo.findAll();
    }
}