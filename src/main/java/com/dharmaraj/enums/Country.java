package com.dharmaraj.enums;

import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Country {

    USA("Dollars", "$", 1.0, Set.of(Language.English), 25.2, Map.of(
            VehicleType.CAR, 1.0,
            VehicleType.BIKE, 0.5,
            VehicleType.SCOOTY, 0.3,
            VehicleType.AUTO, 0.8)),
    INDIA("Rupees", "₹", 0.012, Set.of(Language.Tamil, Language.Hindi, Language.English), 18.0, Map.of(
            VehicleType.CAR, 50.0,
            VehicleType.BIKE, 30.0,
            VehicleType.SCOOTY, 20.0,
            VehicleType.AUTO, 40.0)),
    UK("Pounds", "£", 1.3, Set.of(Language.English), 20.0, Map.of(
            VehicleType.CAR, 1.5,
            VehicleType.BIKE, 0.8,
            VehicleType.SCOOTY, 0.5,
            VehicleType.AUTO, 1.0));

    private final String currency;

    private final String currencySymbol;

    /**
     * Exchange rate is hardcoded for demonstration purpose. In real world, it
     * varies time to time and should be fetched from a reliable source.
     */
    private final Double exchangeRate;

    private final Set<Language> languages;

    /**
     * GST is hardcoded for demonstration purpose.
     */
    private final Double gst;

    public final Map<VehicleType, Double> farePerKm;

}
