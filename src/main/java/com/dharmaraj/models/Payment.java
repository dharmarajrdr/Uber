package com.dharmaraj.models;

import com.dharmaraj.enums.PaymentType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Payment extends DateTimeAudit {

    @OneToOne
    private Ride ride;

    @Enumerated(EnumType.STRING)
    private PaymentType type;
}
