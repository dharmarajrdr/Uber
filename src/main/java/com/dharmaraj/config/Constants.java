package com.dharmaraj.config;

import java.util.Map;

import com.dharmaraj.enums.VehicleType;

public class Constants {

    public static final String DRIVER_ASSIGNMENT_TOPIC = "driver-assignment-topic";

    public static final Map<VehicleType, Double> FARE_PER_KM = Map.of(
            VehicleType.CAR, 50.0,
            VehicleType.BIKE, 30.0,
            VehicleType.SCOOTY, 20.0,
            VehicleType.AUTO, 40.0);
}
