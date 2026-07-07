package com.dharmaraj.services.interfaces;

import com.dharmaraj.models.Location;

public interface FareEstimationStrategy {

    Double estimateFare(Location source, Location destination);
}
