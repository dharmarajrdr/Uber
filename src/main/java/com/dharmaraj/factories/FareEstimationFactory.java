package com.dharmaraj.factories;

import org.springframework.stereotype.Service;

import com.dharmaraj.enums.VehicleType;
import com.dharmaraj.services.interfaces.FareEstimationStrategy;
import com.dharmaraj.strategies.FareEstimation.AutoFareEstimationStrategy;
import com.dharmaraj.strategies.FareEstimation.BikeFareEstimationStrategy;
import com.dharmaraj.strategies.FareEstimation.CarFareEstimationStrategy;
import com.dharmaraj.strategies.FareEstimation.ScootyFareEstimationStrategy;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FareEstimationFactory {

    private final CarFareEstimationStrategy carFareEstimationStrategy;
    private final ScootyFareEstimationStrategy scootyFareEstimationStrategy;
    private final AutoFareEstimationStrategy autoFareEstimationStrategy;
    private final BikeFareEstimationStrategy bikeFareEstimationStrategy;

    public FareEstimationStrategy getInstance(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR: {
                return carFareEstimationStrategy;
            }
            case SCOOTY: {
                return scootyFareEstimationStrategy;
            }
            case AUTO: {
                return autoFareEstimationStrategy;
            }
            case BIKE: {
                return bikeFareEstimationStrategy;
            }
            default: {
                throw new IllegalArgumentException("Invalid vehicle type: " + vehicleType);
            }
        }
    }

}