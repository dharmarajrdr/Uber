package com.dharmaraj.config;

import java.util.Map;

import com.dharmaraj.enums.VehicleType;

public class Constants {

    public static final String DRIVER_ASSIGNMENT_TOPIC = "driver-assignment-topic";

    public static final String RIDE_OTP_KEY_PREFIX = "ride-otp";

    public static final String DRIVER_LOCATION_KEY_PREFIX = "driver-location";

    public static final int PICKUP_LOCATION_THRESHOLD_METERS = 50;

    public static final Map<VehicleType, Double> FARE_PER_KM = Map.of(
            VehicleType.CAR, 50.0,
            VehicleType.BIKE, 30.0,
            VehicleType.SCOOTY, 20.0,
            VehicleType.AUTO, 40.0);

    public static final int RIDE_START_OTP_TTL_SECONDS = 30;

    public static final int RIDE_START_OTP_LENGTH = 6;
}
