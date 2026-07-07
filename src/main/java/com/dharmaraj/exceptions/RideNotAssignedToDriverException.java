package com.dharmaraj.exceptions;

public class RideNotAssignedToDriverException extends RuntimeException {

    public RideNotAssignedToDriverException(Long rideId, Long driverId) {
        super(String.format("Ride with ID %d is not assigned to driver with ID %d.", rideId, driverId));
    }

}
