package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Election;
import com.klu.service.ElectionService;

@RestController
@RequestMapping("/api/elections")
@CrossOrigin(origins = "*")
public class ElectionController {

    @Autowired
    private ElectionService service;

    // 🔥 GET ALL
    @GetMapping
    public List<Election> getAllElections() {
        return service.getAllElections();
    }

    // 🔥 ADD ELECTION (EMAIL TRIGGER WILL WORK HERE)
    @PostMapping
    public Election addElection(@RequestBody Election election) {
        return service.saveElection(election);
    }
}