package com.dharmaraj.enums;

import com.dharmaraj.exceptions.DriverUnavailableException;
import com.dharmaraj.exceptions.MoreThanOneRideInProgressException;

public enum DriverStatus {

    OFFLINE, IDLE, ON_DUTY;

    public void onStartRide(Long rideId, Long driverId) {

        switch (this) {
            case OFFLINE:
                throw new DriverUnavailableException(rideId, driverId);
            case ON_DUTY:
                throw new MoreThanOneRideInProgressException(rideId, driverId);
            default:
                break;
        }
    }
}
