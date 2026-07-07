package com.dharmaraj.strategies.FareEstimation;

import org.springframework.stereotype.Service;

import com.dharmaraj.config.Constants;
import com.dharmaraj.enums.VehicleType;
import com.dharmaraj.models.FareEstimationReport;
import com.dharmaraj.models.Location;
import com.dharmaraj.services.interfaces.FareEstimationStrategy;
import com.dharmaraj.utils.DistanceCalculator;

@Service
public class CarFareEstimationStrategy extends FareEstimationStrategy {

    @Override
    public FareEstimationReport estimateFare(Location source, Location destination) {

        Double farePerKm = Constants.FARE_PER_KM.get(VehicleType.CAR);
        Double distance = DistanceCalculator.getDistanceInMeters(source, destination) / 1000;
        Double surgeMultiplier = getSurgeMultiplierBasedOnTime();
        return new FareEstimationReport(farePerKm, distance, surgeMultiplier, source);
    }

}
