package com.dharmaraj.services.interfaces;

import java.time.LocalDateTime;

import com.dharmaraj.config.Constants;
import com.dharmaraj.enums.TimeRange;
import com.dharmaraj.models.FareEstimationReport;
import com.dharmaraj.models.Location;

public abstract class FareEstimationStrategy {

    protected Double getSurgeMultiplierBasedOnTime() {

        return getSurgeMultiplierBasedOnTime(LocalDateTime.now());
    }

    protected Double getSurgeMultiplierBasedOnTime(LocalDateTime time) {

        int hour = time.getHour();
        TimeRange timeRange = TimeRange.getTimeRange(hour);
        return Constants.SURGE_MULTIPLIER.get(timeRange);
    }

    public abstract FareEstimationReport estimateFare(Location source, Location destination);
}
