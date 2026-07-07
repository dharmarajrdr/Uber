package com.dharmaraj.exceptions;

import com.dharmaraj.models.Location;

public class ServiceNotAvailableException extends RuntimeException {

    public ServiceNotAvailableException(Location location) {
        super("Service is not available in the location: " + location);
    }
}
