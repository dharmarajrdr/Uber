package com.dharmaraj.exceptions;

public class MoreThanOneRideInProgressException extends RuntimeException {

    public MoreThanOneRideInProgressException(Long rideId, Long driverId) {
        super("Driver with ID: " + driverId + " is already on duty and cannot start another ride with ID: " + rideId);
    }

}
