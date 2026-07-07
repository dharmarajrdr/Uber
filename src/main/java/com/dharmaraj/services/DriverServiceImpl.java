package com.dharmaraj.services;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.dharmaraj.config.Constants;
import com.dharmaraj.enums.DriverStatus;
import com.dharmaraj.models.Driver;
import com.dharmaraj.models.Location;
import com.dharmaraj.models.Ride;
import com.dharmaraj.repository.DriverRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final RideService rideService;
    private final DriverRepository driverRepository;
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public Driver getDriverById(Long driverId) {

        return driverRepository.findById(driverId).orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    @Override
    public void updateStatus(Long driverId, DriverStatus status) {

        Driver driver = getDriverById(driverId);
        driver.setStatus(status);
        driverRepository.save(driver);

        if (status == DriverStatus.OFFLINE) {
            String key = Constants.DRIVER_LOCATION_KEY_PREFIX + ":" + String.valueOf(driverId);
            stringRedisTemplate.delete(key);
        }
    }

    @Override
    public void updateLocation(Long driverId, Location location) {

        String key = Constants.DRIVER_LOCATION_KEY_PREFIX + ":" + String.valueOf(driverId);
        String value = location.toString();
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Location getCurrentLocation(Long driverId) {

        String key = Constants.DRIVER_LOCATION_KEY_PREFIX + ":" + String.valueOf(driverId);
        String locationString = stringRedisTemplate.opsForValue().get(key);
        if (locationString == null) {
            return null;
        }

        return Location.fromString(locationString);
    }

    @Override
    public void informArrivalToPassenger(Long driverId, Long rideId) {

        Location driverLocation = getCurrentLocation(driverId);
        rideService.driverArrivedPickupLocation(rideId, driverId, driverLocation);
    }

    @Override
    @Transactional
    public void respondToRideRequest(Long driverId, Long rideId, boolean accept) {

        if (!accept) {
            return;
        }

        Driver driver = getDriverById(driverId);
        driver.onNewRideRequestAccept(rideId);

        Ride ride = rideService.getRideById(rideId);
        ride.onDriverAcceptRideRequest(driver);

        driverRepository.save(driver);
        rideService.updateRide(ride);
    }

}
