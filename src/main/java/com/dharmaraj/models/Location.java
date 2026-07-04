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
}
