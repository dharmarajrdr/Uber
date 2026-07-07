package com.dharmaraj.exceptions;

/**
 * DriverAlreadyAssignedToRideException
 */
public class DriverAlreadyAssignedToRideException extends RuntimeException {

    public DriverAlreadyAssignedToRideException(Long rideId) {
        super(String.format("Driver is already assigned to Ride with ID %d.", rideId));
    }

}
