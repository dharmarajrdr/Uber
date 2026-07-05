package com.dharmaraj.exceptions;

public class RideAlreadyCancelledException extends RuntimeException {

    public RideAlreadyCancelledException(Long rideId) {
        super("Ride with ID " + rideId + " has already been cancelled.");
    }

}
