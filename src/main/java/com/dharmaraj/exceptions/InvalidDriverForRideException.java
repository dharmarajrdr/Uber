package com.dharmaraj.exceptions;

public class InvalidDriverForRideException extends RuntimeException {

    public InvalidDriverForRideException(Long driverId, Long rideId) {
        super("Driver with ID: " + driverId + " is not valid for ride with ID: " + rideId);
    }

}
