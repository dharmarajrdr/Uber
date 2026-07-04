package com.dharmaraj.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VehicleModel {

    SEDAN(VehicleType.CAR),
    SWIFT(VehicleType.CAR),
    HONDA_ACTIVA(VehicleType.SCOOTER),
    PULSAR(VehicleType.BIKE),
    APACHE(VehicleType.BIKE),
    HERO_HONDA(VehicleType.BIKE);

    private final VehicleType vehicleType;
}
