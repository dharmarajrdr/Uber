package com.dharmaraj.models;

import java.util.List;

import com.dharmaraj.enums.RideStatus;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ride extends DateTimeAudit {

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private RideStatus status;

    private Double fare;

    @Embedded
    private Location pickupLocation;

    @Embedded
    private Location dropoffLocation;

    private Double tips;

    private Payment payment;

    private List<RideRequest> rideRequests;
}
