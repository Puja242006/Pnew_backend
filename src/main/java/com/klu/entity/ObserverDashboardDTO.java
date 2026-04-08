package com.klu.entity;

public class ObserverDashboardDTO {

    private int assignedLocations;
    private int observationsToday;
    private int reportsSubmitted;
    private int irregularities;

    // Constructor
    public ObserverDashboardDTO(int assignedLocations, int observationsToday, int reportsSubmitted, int irregularities) {
        this.assignedLocations = assignedLocations;
        this.observationsToday = observationsToday;
        this.reportsSubmitted = reportsSubmitted;
        this.irregularities = irregularities;
    }

    // Getters
    public int getAssignedLocations() {
        return assignedLocations;
    }

    public int getObservationsToday() {
        return observationsToday;
    }

    public int getReportsSubmitted() {
        return reportsSubmitted;
    }

    public int getIrregularities() {
        return irregularities;
    }
}