package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Discussion;
import com.klu.service.DiscussionService;

@RestController
@RequestMapping("/api/discussions")
@CrossOrigin(origins = "*")
public class DiscussionController {

    @Autowired
    private DiscussionService service;

    // GET ALL
    @GetMapping
    public List<Discussion> getAllDiscussions() {
        return service.getAllDiscussions();
    }

    // CREATE
    @PostMapping
    public Discussion addDiscussion(@RequestBody Discussion discussion) {
        return service.saveDiscussion(discussion);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteDiscussion(@PathVariable Long id) {
        service.deleteDiscussion(id);
    }

    // 🔥 LIKE API (THIS FIXES YOUR ERROR)
    @PutMapping("/like/{id}")
    public void likeDiscussion(@PathVariable Long id) {
        service.likeDiscussion(id);
    }
}