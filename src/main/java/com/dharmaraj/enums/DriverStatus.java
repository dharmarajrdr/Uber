package com.dharmaraj.enums;

import com.dharmaraj.exceptions.DriverUnavailableException;
import com.dharmaraj.exceptions.MoreThanOneRideInProgressException;
import com.dharmaraj.exceptions.RideNotAssignedToDriverException;

public enum DriverStatus {

    OFFLINE, IDLE, IN_RIDE, WAY_TO_PICKUP;

    public void onStartRide(Long rideId, Long driverId) {

        switch (this) {
            case OFFLINE:
                throw new DriverUnavailableException(rideId, driverId);
            case IN_RIDE:
                throw new MoreThanOneRideInProgressException(rideId, driverId);
            case IDLE:
                throw new RideNotAssignedToDriverException(rideId, driverId);
            default:
                break; // No exception for WAY_TO_PICKUP status
        }
    }

    public void onNewRideRequestAccept(Long rideId, Long driverId) {

        switch (this) {
            case OFFLINE:
                throw new DriverUnavailableException(rideId, driverId);
            case IN_RIDE:
            case WAY_TO_PICKUP:
                throw new MoreThanOneRideInProgressException(rideId, driverId);
            default:
                break; // No exception for IDLE status, as the driver can accept a new ride request
        }
    }
}
