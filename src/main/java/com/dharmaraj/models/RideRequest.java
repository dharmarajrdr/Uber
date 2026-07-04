package com.dharmaraj.models;

import com.dharmaraj.enums.DriverResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class RideRequest extends DateTimeAudit {

    @ManyToOne
    private Ride ride;

    @ManyToOne
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private DriverResponse response;
}
