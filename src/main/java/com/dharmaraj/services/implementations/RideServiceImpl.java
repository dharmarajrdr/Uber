package com.dharmaraj.services.implementations;

import org.springframework.stereotype.Service;

import com.dharmaraj.enums.VehicleType;
import com.dharmaraj.exceptions.RideNotFoundException;
import com.dharmaraj.exceptions.SameDestinationNotAllowedException;
import com.dharmaraj.models.Driver;
import com.dharmaraj.models.Location;
import com.dharmaraj.models.Passenger;
import com.dharmaraj.models.Ride;
import com.dharmaraj.repository.RideRepository;
import com.dharmaraj.services.interfaces.DriverAssignmentService;
import com.dharmaraj.services.interfaces.FareEstimateService;
import com.dharmaraj.services.interfaces.OtpService;
import com.dharmaraj.services.interfaces.PassengerService;
import com.dharmaraj.services.interfaces.RideService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RideServiceImpl implements RideService {

    private final OtpService otpService;
    private final RideRepository rideRepository;
    private final PassengerService passengerService;
    private final FareEstimateService fareEstimateService;
    private final DriverAssignmentService driverAssignmentService;

    @Override
    public Ride createRide(Long passengerId, Location source, Location destination, VehicleType vehicleType) {

        if (source.isEqual(destination)) {
            throw new SameDestinationNotAllowedException();
        }

        Passenger passenger = passengerService.getPassengerById(passengerId);
        Double fare = fareEstimateService.estimateFare(source, destination, vehicleType);

        Ride ride = new Ride();
        ride.setPassenger(passenger);
        ride.setPickupLocation(source);
        ride.setDropoffLocation(destination);
        ride.setFare(fare);
        rideRepository.save(ride);
        driverAssignmentService.rideCreated(ride.getId());
        return ride;
    }

    @Override
    public void startRide(Long rideId, Long driverId, String otp) {

        Ride ride = getRideById(rideId);
        ride.onStart(driverId);

        Driver driver = ride.getDriver();
        driver.onStartRide(rideId);

        otpService.validate(ride.getPassenger().getId(), otp);

        ride.setDriver(driver);

        rideRepository.save(ride);
    }

    @Override
    public void cancelRide(Long rideId, Long passengerId) {

        Ride ride = getRideById(rideId);

        ride.onCancel(passengerId);

        rideRepository.save(ride);
    }

    @Override
    public Ride getRideById(Long rideId) {

        return rideRepository.findById(rideId).orElseThrow(() -> new RideNotFoundException(rideId));
    }

    @Override
    public void driverArrivedPickupLocation(Long rideId, Long driverId, Location driverLocation) {

        Ride ride = getRideById(rideId);
        ride.onDriverArrival(driverId, driverLocation);
        rideRepository.save(ride);
    }

    @Override
    public void updateRide(Ride ride) {

        rideRepository.save(ride);
    }

}
