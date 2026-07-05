package com.dharmaraj.services;

import org.springframework.stereotype.Service;

import com.dharmaraj.enums.VehicleType;
import com.dharmaraj.models.Location;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FareEstimateServiceImpl implements FareEstimateService {

    private final FareEstimationFactory fareEstimationFactory;

    @Override
    public Double estimateFare(Location source, Location destination, VehicleType vehicleType) {

        return fareEstimationFactory.getInstance(vehicleType).estimateFare(source, destination);
    }

}
