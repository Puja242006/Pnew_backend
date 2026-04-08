package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Discussion;
import com.klu.repository.DiscussionRepository;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository repository;

    // GET ALL
    public List<Discussion> getAllDiscussions() {
        return repository.findAll();
    }

    // CREATE
    public Discussion saveDiscussion(Discussion discussion) {
        return repository.save(discussion);
    }

    // DELETE
    public void deleteDiscussion(Long id) {
        repository.deleteById(id);
    }

    // 🔥 LIKE FEATURE
    public void likeDiscussion(Long id) {
        Discussion d = repository.findById(id).orElse(null);

        if (d != null) {
            d.setLikes(d.getLikes() + 1);
            repository.save(d);
        }
    }
}