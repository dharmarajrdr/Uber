package com.dharmaraj.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TimeRange {
    EARLY_MORNING(0, 6),
    MORNING_PEAK(6, 10),
    DAY_TIME(10, 16),
    EVENING_PEAK(16, 21),
    LATE_NIGHT(21, 24);

    private final int startHour;
    private final int endHour;

    public static TimeRange getTimeRange(int hour) {
        for (TimeRange timeRange : TimeRange.values()) {
            if (hour >= timeRange.getStartHour() && hour < timeRange.getEndHour()) {
                return timeRange;
            }
        }
        throw new IllegalArgumentException("Invalid hour: " + hour);
    }
}
