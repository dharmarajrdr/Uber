package com.dharmaraj.models;

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

}
