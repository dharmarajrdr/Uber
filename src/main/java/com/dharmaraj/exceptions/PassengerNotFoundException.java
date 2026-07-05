package com.dharmaraj.exceptions;

public class PassengerNotFoundException extends RuntimeException {

    public PassengerNotFoundException(Long passengerId) {

        super("Passenger not found with ID: " + passengerId);
    }

}
