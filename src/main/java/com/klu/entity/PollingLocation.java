package com.klu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "polling_locations")
public class PollingLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String location;
    private String distance;

    public PollingLocation() {}

    public PollingLocation(Long userId, String location, String distance) {
        this.userId = userId;
        this.location = location;
        this.distance = distance;
    }

    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDistance() { return distance; }
    public void setDistance(String distance) { this.distance = distance; }
}