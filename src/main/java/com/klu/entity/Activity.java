package com.klu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;
    private String action;
    private String time;

    public Activity() {}

    public Activity(String user, String action, String time) {
        this.user = user;
        this.action = action;
        this.time = time;
    }

    public Long getId() { return id; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
}