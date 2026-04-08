package com.klu.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin("*")
public class AnalyticsController {

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> data = new HashMap<>();
        data.put("totalVotes", "1.42M");
        data.put("turnout", "68.5%");
        data.put("pollingStations", "245");
        data.put("dataPoints", "2.8M");
        return data;
    }

    @GetMapping("/turnout")
    public List<Map<String, Object>> getTurnout() {
        return List.of(
            Map.of("time", "8 AM", "voters", 120),
            Map.of("time", "10 AM", "voters", 450),
            Map.of("time", "12 PM", "voters", 780),
            Map.of("time", "2 PM", "voters", 920),
            Map.of("time", "4 PM", "voters", 1150),
            Map.of("time", "6 PM", "voters", 1420)
        );
    }

    @GetMapping("/demographics")
    public List<Map<String, Object>> getDemographics() {
        return List.of(
            Map.of("name", "18-25", "value", 18),
            Map.of("name", "26-35", "value", 25),
            Map.of("name", "36-50", "value", 32),
            Map.of("name", "51-65", "value", 20),
            Map.of("name", "65+", "value", 5)
        );
    }

    @GetMapping("/districts")
    public List<Map<String, Object>> getDistricts() {
        return List.of(
            Map.of("district", "District 1", "votes", 2400),
            Map.of("district", "District 2", "votes", 1398),
            Map.of("district", "District 3", "votes", 3800),
            Map.of("district", "District 4", "votes", 3908),
            Map.of("district", "District 5", "votes", 4800)
        );
    }

    @GetMapping("/metrics")
    public List<Map<String, Object>> getMetrics() {
        return List.of(
            Map.of("label", "Voter Turnout", "value", "68.5%", "change", "+5.2%", "trend", "up"),
            Map.of("label", "Avg. Wait Time", "value", "12 min", "change", "-3 min", "trend", "down"),
            Map.of("label", "Polling Stations", "value", "245", "change", "+12", "trend", "up"),
            Map.of("label", "Issues Reported", "value", "23", "change", "-8", "trend", "down")
        );
    }
}