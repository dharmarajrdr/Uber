package com.dharmaraj.enums;

import com.dharmaraj.exceptions.ArrivalAlreadyInformedException;
import com.dharmaraj.exceptions.DriverAlreadyAssignedToRideException;
import com.dharmaraj.exceptions.DriverNotAssignedToRideException;
import com.dharmaraj.exceptions.DriverNotReachedPickupException;
import com.dharmaraj.exceptions.RideAlreadyCancelledException;
import com.dharmaraj.exceptions.RideAlreadyCompletedException;
import com.dharmaraj.exceptions.RideAlreadyStartedException;
import com.dharmaraj.exceptions.UnableToStartCancelledRideException;
import com.dharmaraj.models.Location;

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

    public void onCancel(Long rideId, Long passengerId) {

        switch (this) {
            case COMPLETED:
                throw new RideAlreadyCompletedException(rideId);
            case CANCELLED:
                throw new RideAlreadyCancelledException(rideId);
            case IN_PROGRESS:
                throw new RideAlreadyStartedException(rideId);
            default:
                break; // No exception for CREATED, DRIVER_ASSIGNED, DRIVER_REACHED_PICKUP
        }
    }

    public void onDriverArrival(Long rideId, Long driverId, Location driverLocation) {

        switch (this) {
            case CREATED:
                throw new DriverNotAssignedToRideException(rideId);
            case COMPLETED:
                throw new RideAlreadyCompletedException(rideId);
            case CANCELLED:
                throw new RideAlreadyCancelledException(rideId);
            case IN_PROGRESS:
                throw new RideAlreadyStartedException(rideId);
            case DRIVER_REACHED_PICKUP:
                throw new ArrivalAlreadyInformedException(rideId, driverId);
            default:
                break; // No exception for DRIVER_ASSIGNED
        }
    }

    public void onDriverAcceptRideRequest(Long id) {

        switch (this) {
            case COMPLETED:
                throw new RideAlreadyCompletedException(id);
            case CANCELLED:
                throw new RideAlreadyCancelledException(id);
            case IN_PROGRESS:
                throw new RideAlreadyStartedException(id);
            case DRIVER_ASSIGNED:
            case DRIVER_REACHED_PICKUP:
                throw new DriverAlreadyAssignedToRideException(id);
            default:
                break; // No exception for CREATED
        }
    }
}
