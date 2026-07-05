package com.dharmaraj.services;

import com.dharmaraj.models.Location;

public interface FareEstimationStrategy {

    Double estimateFare(Location source, Location destination);
}
