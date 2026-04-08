package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.PollingLocation;
import com.klu.repository.PollingRepository;

@Service
public class PollingService {

    @Autowired
    private PollingRepository repository;

    public PollingLocation getPollingLocation(Long userId) {
        return repository.findByUserId(userId);
    }

    public PollingLocation saveLocation(PollingLocation location) {
        return repository.save(location);
    }
}