package com.dharmaraj.services.interfaces;

import com.dharmaraj.enums.VehicleType;
import com.dharmaraj.models.Location;
import com.dharmaraj.models.Ride;

public interface RideService {

    Ride createRide(Long passengerId, Location source, Location destination, VehicleType vehicleType);

    Ride getRideById(Long rideId);

    void startRide(Long rideId, Long driverId, String otp);

    void cancelRide(Long rideId, Long passengerId);

    void driverArrivedPickupLocation(Long rideId, Long driverId, Location driverLocation);

    void updateRide(Ride ride);
}
