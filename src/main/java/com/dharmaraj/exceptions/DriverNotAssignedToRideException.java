package com.dharmaraj.exceptions;

public class DriverNotAssignedToRideException extends RuntimeException {

    public DriverNotAssignedToRideException(Long rideId) {
        super("Driver not assigned to ride with ID: " + rideId);
    }

}
