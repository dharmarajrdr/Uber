package com.dharmaraj.models;

import com.dharmaraj.enums.DriverStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Driver extends DateTimeAudit {

    @ManyToOne
    private Vehicle vehicle;

    @Enumerated(EnumType.STRING)
    private DriverStatus status;

    private Double averageRating;

    @Column(nullable = false, unique = true)
    private String upiId;

    public void onStartRide(Long rideId) {

        status.onStartRide(rideId, this.getId());

        this.setStatus(DriverStatus.IN_RIDE);
    }

    public void onNewRideRequestAccept(Long rideId) {

        status.onNewRideRequestAccept(rideId, this.getId());

        this.setStatus(DriverStatus.WAY_TO_PICKUP);
    }
}
