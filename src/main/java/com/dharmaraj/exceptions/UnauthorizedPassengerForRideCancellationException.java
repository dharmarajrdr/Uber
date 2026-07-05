package com.dharmaraj.exceptions;

public class UnauthorizedPassengerForRideCancellationException extends RuntimeException {

    public UnauthorizedPassengerForRideCancellationException() {
        super("Only the passenger who booked the ride can cancel it.");
    }

}