package com.dharmaraj.exceptions;

public class RideAlreadyCompletedException extends RuntimeException {

    public RideAlreadyCompletedException(Long rideId) {
        super("Ride with ID: " + rideId + " has already been completed.");
    }

}
