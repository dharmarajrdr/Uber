package com.dharmaraj.models;

import java.security.Provider.Service;

import com.dharmaraj.enums.Country;
import com.dharmaraj.exceptions.ServiceNotAvailableException;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Embeddable
@AllArgsConstructor
public class Location {

    private final Double latitude;

    private final Double longitude;

    public boolean isEqual(Location other) {
        return this.latitude.equals(other.latitude) && this.longitude.equals(other.longitude);
    }

    public String toString() {

        return latitude + "," + longitude;
    }

    public static Location fromString(String locationString) {

        String[] parts = locationString.split(",");
        double latitude = Double.parseDouble(parts[0]);
        double longitude = Double.parseDouble(parts[1]);
        return new Location(latitude, longitude);
    }

    /**
     * This logic is not accurate and is just for demonstration purposes.
     */
    public Country getCountry() {

        if (latitude >= 8.0 && latitude <= 37.0 && longitude >= 68.0 && longitude <= 97.0) {
            return Country.INDIA;
        } else if (latitude >= 24.0 && latitude <= 49.0 && longitude >= -125.0 && longitude <= -66.0) {
            return Country.USA;
        } else {
            throw new ServiceNotAvailableException(this);
        }
    }

}
