package com.dharmaraj.exceptions;

public class DriverUnavailableException extends RuntimeException {

    public DriverUnavailableException(Long rideId, Long driverId) {
        super("Driver with ID: " + driverId + " is currently unavailable for ride with ID: " + rideId);
    }

}
