package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Activity;
import com.klu.repository.ActivityRepository;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository repository;

    public List<Activity> getAllActivities() {
        return repository.findAll();
    }

    public Activity saveActivity(Activity activity) {
        return repository.save(activity);
    }
}