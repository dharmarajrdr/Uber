package com.dharmaraj.services.implementations;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.dharmaraj.config.Constants;
import com.dharmaraj.factories.DriverAssignmentFactory;
import com.dharmaraj.models.Ride;
import com.dharmaraj.services.interfaces.DriverAssignmentService;
import com.dharmaraj.services.interfaces.DriverAssignmentStrategy;
import com.dharmaraj.services.interfaces.RideService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DriverAssignmentServiceImpl implements DriverAssignmentService {

    private final RideService rideService;
    private final KafkaTemplate<String, Long> kafkaTemplate;
    private final DriverAssignmentFactory driverAssignmentFactory;

    @Override
    public void rideCreated(Long rideId) {

        kafkaTemplate.send(Constants.DRIVER_ASSIGNMENT_TOPIC, rideId);
    }

    @KafkaListener(topics = Constants.DRIVER_ASSIGNMENT_TOPIC, groupId = "ride-service-group")
    public void consume(Long rideId) {

        Ride ride = rideService.getRideById(rideId);
        DriverAssignmentStrategy driverAssignmentStrategy = driverAssignmentFactory
                .getInstance(com.dharmaraj.enums.DriverAssignmentStrategy.NEAREST_DRIVER_ASSIGNMENT_STRATEGY);
        driverAssignmentStrategy.assignDriver(ride);
    }

}
