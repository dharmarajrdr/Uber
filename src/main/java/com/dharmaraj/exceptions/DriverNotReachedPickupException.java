package com.dharmaraj.exceptions;

public class DriverNotReachedPickupException extends RuntimeException {

    public DriverNotReachedPickupException(Long rideId, Long driverId) {
        super("Driver with ID: " + driverId + " has not reached the pickup location for ride with ID: " + rideId);
    }

}
