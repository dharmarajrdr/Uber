package com.dharmaraj.utils;

import com.dharmaraj.models.Location;

public class DistanceCalculator {

    public static double getDistanceInMeters(Location source, Location destination) {

        Double sourceLatitude = source.getLatitude();
        Double sourceLongitude = source.getLongitude();
        Double destinationLatitude = destination.getLatitude();
        Double destinationLongitude = destination.getLongitude();

        // Haversine formula to calculate distance between two points on the Earth
        final int EARTH_RADIUS_KM = 6371; // Radius of the Earth in kilometers
        double dLat = Math.toRadians(destinationLatitude - sourceLatitude);
        double dLon = Math.toRadians(destinationLongitude - sourceLongitude);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(sourceLatitude)) * Math.cos(Math.toRadians(destinationLatitude))
                        * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS_KM * c * 1000;
    }
}
