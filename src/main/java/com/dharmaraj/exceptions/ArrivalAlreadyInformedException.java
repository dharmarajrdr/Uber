package com.dharmaraj.exceptions;

public class ArrivalAlreadyInformedException extends RuntimeException {

    public ArrivalAlreadyInformedException(Long rideId, Long driverId) {
        super("Driver with ID: " + driverId + " has already informed arrival for ride with ID: " + rideId);
    }

}
