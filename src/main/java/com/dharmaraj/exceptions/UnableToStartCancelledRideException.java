package com.dharmaraj.exceptions;

public class UnableToStartCancelledRideException extends RuntimeException {

    public UnableToStartCancelledRideException(Long rideId) {
        super("Cannot start a ride with ID: " + rideId + " as it has been cancelled.");
    }

}
