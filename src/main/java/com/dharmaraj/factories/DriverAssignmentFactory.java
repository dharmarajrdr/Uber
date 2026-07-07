package com.dharmaraj.factories;

import org.springframework.stereotype.Service;

import com.dharmaraj.services.interfaces.DriverAssignmentStrategy;
import com.dharmaraj.strategies.DriverAssignment.NearestDriverAssignmentStrategy;
import com.dharmaraj.strategies.DriverAssignment.TopRatedDriverAssignmentStrategy;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DriverAssignmentFactory {

    private final NearestDriverAssignmentStrategy nearestDriverAssignmentStrategy;
    private final TopRatedDriverAssignmentStrategy topRatedDriverAssignmentStrategy;

    public DriverAssignmentStrategy getInstance(com.dharmaraj.enums.DriverAssignmentStrategy strategy) {

        switch (strategy) {
            case NEAREST_DRIVER_ASSIGNMENT_STRATEGY: {
                return nearestDriverAssignmentStrategy;
            }
            case TOP_RATED_DRIVER_ASSIGNMENT_STRATEGY: {
                return topRatedDriverAssignmentStrategy;
            }
            default: {
                throw new IllegalArgumentException("Invalid strategy: " + strategy);
            }
        }
    }
}
