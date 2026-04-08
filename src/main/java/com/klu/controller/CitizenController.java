package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Citizen;
import com.klu.service.CitizenService;

@RestController
@RequestMapping("/api/citizens")
@CrossOrigin(origins = "*")
public class CitizenController {

    @Autowired
    private CitizenService service;

    // GET ALL
    @GetMapping
    public List<Citizen> getAllCitizens() {
        return service.getAllCitizens();
    }

    // ADD
    @PostMapping
    public Citizen addCitizen(@RequestBody Citizen citizen) {
        return service.saveCitizen(citizen);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Citizen getCitizen(@PathVariable Long id) {
        return service.getCitizenById(id);
    }

    // 🔥 GET VOTER STATUS
    @GetMapping("/status/{id}")
    public String getVoterStatus(@PathVariable Long id) {
        Citizen citizen = service.getCitizenById(id);
        return citizen != null ? citizen.getVoterStatus() : "Not Found";
    }

    // UPDATE
    @PutMapping("/{id}")
    public Citizen updateCitizen(@PathVariable Long id, @RequestBody Citizen citizen) {
        citizen.setId(id);
        return service.saveCitizen(citizen);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCitizen(@PathVariable Long id) {
        service.deleteCitizen(id);
        return "Citizen deleted";
    }
}