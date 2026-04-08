package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Citizen;
import com.klu.repository.CitizenRepository;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository repository;

    public List<Citizen> getAllCitizens() {
        return repository.findAll();
    }

    public Citizen saveCitizen(Citizen citizen) {
        return repository.save(citizen);
    }

    public Citizen getCitizenById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteCitizen(Long id) {
        repository.deleteById(id);
    }
}