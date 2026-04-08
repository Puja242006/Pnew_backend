package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Reply;
import com.klu.service.ReplyService;

@RestController
@RequestMapping("/api/replies")
@CrossOrigin(origins = "*")
public class ReplyController {

    @Autowired
    private ReplyService service;

    @GetMapping("/{discussionId}")
    public List<Reply> getReplies(@PathVariable Long discussionId) {
        return service.getReplies(discussionId);
    }

    @PostMapping
    public Reply addReply(@RequestBody Reply reply) {
        return service.addReply(reply);
    }
}