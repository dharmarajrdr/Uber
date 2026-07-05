package com.dharmaraj.enums;

import com.dharmaraj.exceptions.DriverNotAssignedToRideException;
import com.dharmaraj.exceptions.DriverNotReachedPickupException;
import com.dharmaraj.exceptions.RideAlreadyCompletedException;
import com.dharmaraj.exceptions.RideAlreadyStartedException;
import com.dharmaraj.exceptions.UnableToStartCancelledRideException;

public enum RideStatus {

    CREATED, DRIVER_ASSIGNED, DRIVER_REACHED_PICKUP, IN_PROGRESS, COMPLETED, CANCELLED;

    public void onStart(Long rideId, Long driverId) {

        switch (this) {
            case CREATED:
                throw new DriverNotAssignedToRideException(rideId);
            case COMPLETED:
                throw new RideAlreadyCompletedException(rideId);
            case CANCELLED:
                throw new UnableToStartCancelledRideException(rideId);
            case DRIVER_ASSIGNED:
                throw new DriverNotReachedPickupException(rideId, driverId);
            case IN_PROGRESS:
                throw new RideAlreadyStartedException(rideId);
            default:
                break; // No exception for DRIVER_REACHED_PICKUP
        }
    }
}
