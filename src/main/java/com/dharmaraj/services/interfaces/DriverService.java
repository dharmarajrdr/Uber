package com.dharmaraj.services.interfaces;

import com.dharmaraj.enums.DriverStatus;
import com.dharmaraj.models.Driver;
import com.dharmaraj.models.Location;

public interface DriverService {

    void updateStatus(Long driverId, DriverStatus status);

    void updateLocation(Long driverId, Location location);

    Location getCurrentLocation(Long driverId);

    Driver getDriverById(Long driverId);

    void informArrivalToPassenger(Long driverId, Long rideId);

    void respondToRideRequest(Long driverId, Long rideId, boolean accept);
}
