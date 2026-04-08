package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Reply;
import com.klu.repository.ReplyRepository;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository repository;

    public List<Reply> getReplies(Long discussionId) {
        return repository.findByDiscussionId(discussionId);
    }

    public Reply addReply(Reply reply) {
        return repository.save(reply);
    }
}