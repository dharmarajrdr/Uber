package com.dharmaraj.exceptions;

import com.dharmaraj.config.Constants;

public class PickupLocationNotReachedException extends RuntimeException {

    public PickupLocationNotReachedException(double distanceToPickup) {

        super(String.format(
                "Driver not within %d meters of pickup location. Distance: %.2f meters away from pickup location.",
                Constants.PICKUP_LOCATION_THRESHOLD_METERS, distanceToPickup));
    }

}
