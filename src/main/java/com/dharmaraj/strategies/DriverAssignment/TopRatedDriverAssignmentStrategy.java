package com.dharmaraj.strategies.DriverAssignment;

import org.springframework.stereotype.Service;

import com.dharmaraj.models.Ride;
import com.dharmaraj.services.interfaces.DriverAssignmentStrategy;

@Service
public class TopRatedDriverAssignmentStrategy implements DriverAssignmentStrategy {

    @Override
    public void assignDriver(Ride ride) {

        throw new UnsupportedOperationException("Unimplemented method 'assignDriver'");
    }

}
