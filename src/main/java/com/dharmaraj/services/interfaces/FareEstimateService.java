package com.dharmaraj.services.interfaces;

import com.dharmaraj.enums.VehicleType;
import com.dharmaraj.models.Location;

public interface FareEstimateService {

    Double estimateFare(Location source, Location destination, VehicleType vehicleType);
}
