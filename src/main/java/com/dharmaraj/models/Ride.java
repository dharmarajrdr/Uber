package com.dharmaraj.models;

import java.util.List;

import com.dharmaraj.config.Constants;
import com.dharmaraj.enums.DriverStatus;
import com.dharmaraj.enums.RideStatus;
import com.dharmaraj.exceptions.DriverNotAssignedToRideException;
import com.dharmaraj.exceptions.InvalidDriverForRideException;
import com.dharmaraj.exceptions.PickupLocationNotReachedException;
import com.dharmaraj.exceptions.UnauthorizedPassengerForRideCancellationException;
import com.dharmaraj.services.DistanceCalculator;

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

    public void onStart(Long driverId) {

        if (driver == null) {
            throw new DriverNotAssignedToRideException(this.getId());
        }
        if (!driver.getId().equals(driverId)) {
            throw new InvalidDriverForRideException(driver.getId(), this.getId());
        }

        status.onStart(getId(), getDriver().getId());

        this.setStatus(RideStatus.IN_PROGRESS);
    }

    public void onCancel(Long passengerId) {

        if (this.getPassenger().getId() != passengerId) {
            throw new UnauthorizedPassengerForRideCancellationException();
        }

        status.onCancel(getId(), passengerId);

        if (driver != null) {
            driver.setStatus(DriverStatus.IDLE);
        }

        this.setStatus(RideStatus.CANCELLED);
    }

    public void onDriverArrival(Long driverId, Location driverLocation) {

        if (driver == null) {
            throw new DriverNotAssignedToRideException(this.getId());
        }
        if (!driver.getId().equals(driverId)) {
            throw new InvalidDriverForRideException(driver.getId(), this.getId());
        }

        status.onDriverArrival(getId(), driverId, driverLocation);

        double distanceToPickup = DistanceCalculator.getDistanceInMeters(driverLocation, pickupLocation);
        if (distanceToPickup > Constants.PICKUP_LOCATION_THRESHOLD_METERS) {
            throw new PickupLocationNotReachedException(distanceToPickup);
        }

        this.setStatus(RideStatus.DRIVER_REACHED_PICKUP);
    }

    public void onDriverAcceptRideRequest(Driver driver) {

        if (this.driver == null) {
            throw new DriverNotAssignedToRideException(this.getId());
        }

        status.onDriverAcceptRideRequest(this.getId());
        this.setStatus(RideStatus.DRIVER_ASSIGNED);
        this.setDriver(driver);
    }

}
