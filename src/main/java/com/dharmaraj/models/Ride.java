package com.dharmaraj.models;

import java.util.List;

import com.dharmaraj.enums.RideStatus;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    private RideStatus status = RideStatus.CREATED;

    private Double fare = 0.0;

    @Embedded
    private Location pickupLocation;

    @Embedded
    private Location dropoffLocation;

    private Integer tips = 0;

    @OneToOne
    private Payment payment;

    private List<RideRequest> rideRequests;
}
