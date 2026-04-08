package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Election;
import com.klu.entity.User;
import com.klu.repository.ElectionRepository;
import com.klu.repository.UserRepository;

@Service
public class ElectionService {

    @Autowired
    private ElectionRepository electionRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private EmailService emailService;

    // 🔥 GET ALL ELECTIONS
    public List<Election> getAllElections() {
        return electionRepo.findAll();
    }

    // 🔥 SAVE ELECTION + SEND EMAIL TO ALL USERS
    public Election saveElection(Election election) {

        // 1️⃣ Save election
        Election savedElection = electionRepo.save(election);

        // 2️⃣ 🔥 GET ALL USERS (ALL ROLES)
        List<User> users = userRepo.findAll();

        // 3️⃣ 🔥 SEND EMAIL TO EVERY USER
        for (User user : users) {

            if (user.getEmail() != null) {

                System.out.println("Sending email to: " + user.getEmail()); // debug

                emailService.sendElectionEmail(
                        user.getEmail(),
                        savedElection.getTitle()
                );
            }
        }

        return savedElection;
    }
}