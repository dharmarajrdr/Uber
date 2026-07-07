package com.dharmaraj.services.implementations;

import org.springframework.stereotype.Service;

import com.dharmaraj.enums.VehicleType;
import com.dharmaraj.factories.FareEstimationFactory;
import com.dharmaraj.models.FareEstimationReport;
import com.dharmaraj.models.Location;
import com.dharmaraj.services.interfaces.FareEstimateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FareEstimateServiceImpl implements FareEstimateService {

    private final FareEstimationFactory fareEstimationFactory;

    @Override
    public FareEstimationReport estimateFare(Location source, Location destination, VehicleType vehicleType) {

        return fareEstimationFactory.getInstance(vehicleType).estimateFare(source, destination);
    }

}
