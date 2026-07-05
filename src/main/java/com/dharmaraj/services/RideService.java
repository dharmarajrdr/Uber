package com.dharmaraj.services;

import com.dharmaraj.enums.VehicleType;
import com.dharmaraj.models.Location;
import com.dharmaraj.models.Ride;

public interface RideService {

    Ride createRide(Long passengerId, Location source, Location destination, VehicleType vehicleType);

    Ride getRideById(Long rideId);
}
