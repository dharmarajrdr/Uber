package com.dharmaraj.enums;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Country {

    USA("Dollars", "$", 1.0, Set.of(Language.English), 25.2),
    INDIA("Rupees", "₹", 0.012, Set.of(Language.Tamil, Language.Hindi, Language.English), 18.0),
    BRAZIL("Reais", "R$", 0.19, Set.of(Language.Portuguese), 20.0);

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

}
