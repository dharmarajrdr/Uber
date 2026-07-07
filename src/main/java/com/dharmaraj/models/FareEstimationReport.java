package com.dharmaraj.models;

import com.dharmaraj.enums.Country;

import lombok.Getter;

@Getter
public class FareEstimationReport {

    private final Double farePerKm;

    private final Double distance;

    private final Double surgeMultiplierBasedOnTime;

    private final Double estimatedFare;

    private final Double gst;

    public FareEstimationReport(Double farePerKm, Double distance, Double surgeMultiplierBasedOnTime, Country country) {

        this.farePerKm = farePerKm;
        this.distance = distance;
        this.surgeMultiplierBasedOnTime = surgeMultiplierBasedOnTime;
        this.gst = country.getGst();
        Double serviceCharge = farePerKm * distance * surgeMultiplierBasedOnTime;
        this.estimatedFare = serviceCharge + (serviceCharge * this.gst);
    }
}
