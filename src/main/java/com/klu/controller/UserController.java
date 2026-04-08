package com.klu.controller;

import com.klu.entity.User;
import com.klu.repository.UserRepository;
import com.klu.dto.UserDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ✅ ADD ModelMapper
    @Autowired
    private ModelMapper modelMapper;

    // ===============================
    // ✅ GET ALL USERS (EXISTING)
    // ===============================
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ===============================
    // ✅ NEW: GET ALL USERS (DTO)
    // ===============================
    @GetMapping("/dto")
    public List<UserDTO> getAllUsersDTO() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    // ===============================
    // ✅ GET USER BY ID (EXISTING)
    // ===============================
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    // ===============================
    // ✅ UPDATE USER (EXISTING)
    // ===============================
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,
                                        @RequestBody User updatedUser) {
        try {
            Optional<User> userOptional = userRepository.findById(id);

            if (userOptional.isEmpty()) {
                return ResponseEntity.status(404).body("User not found");
            }

            User existing = userOptional.get();

            existing.setName(updatedUser.getName());
            existing.setEmail(updatedUser.getEmail());

            userRepository.save(existing);

            return ResponseEntity.ok("User updated successfully ✅");

        } catch (Exception e) {
            return ResponseEntity.status(400)
                    .body("Update failed ❌: " + e.getMessage());
        }
    }
}