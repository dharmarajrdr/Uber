package com.dharmaraj.models;

import lombok.Getter;

@Getter
public class FareEstimationReport {

    private final Double farePerKm;

    private final Double distance;

    private final Double surgeMultiplierBasedOnTime;

    private final Double estimatedFare;

    private final Double gst;

    public FareEstimationReport(Double farePerKm, Double distance, Double surgeMultiplierBasedOnTime, Location source) {

        this.farePerKm = farePerKm;
        this.distance = distance;
        this.surgeMultiplierBasedOnTime = surgeMultiplierBasedOnTime;
        this.gst = source.getCountry().getGst();
        Double serviceCharge = farePerKm * distance * surgeMultiplierBasedOnTime;
        this.estimatedFare = serviceCharge + (serviceCharge * this.gst);
    }
}
