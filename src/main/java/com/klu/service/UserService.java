package com.klu.service;

import com.klu.entity.User;
import com.klu.dto.UserDTO;
import com.klu.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // ✅ ADD ModelMapper
    @Autowired
    private ModelMapper modelMapper;

    // ===============================
    // ✅ EXISTING: UPDATE USER (UNCHANGED)
    // ===============================
    public User updateUser(Long id, User updatedUser) {
        User existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());

        return repo.save(existing);
    }

    // ===============================
    // ✅ NEW: GET ALL USERS (DTO)
    // ===============================
    public List<UserDTO> getAllUsersDTO() {
        return repo.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }
}