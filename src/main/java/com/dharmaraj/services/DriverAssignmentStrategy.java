package com.dharmaraj.services;

import com.dharmaraj.models.Ride;

public interface DriverAssignmentStrategy {

    void assignDriver(Ride ride);
}
