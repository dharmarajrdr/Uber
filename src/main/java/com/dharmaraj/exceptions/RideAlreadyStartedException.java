package com.dharmaraj.exceptions;

public class RideAlreadyStartedException extends RuntimeException {

    public RideAlreadyStartedException(Long rideId) {
        super("Ride with ID: " + rideId + " has already started.");
    }

}
