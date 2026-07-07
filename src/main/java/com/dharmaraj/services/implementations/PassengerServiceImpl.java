package com.dharmaraj.services.implementations;

import org.springframework.stereotype.Service;

import com.dharmaraj.exceptions.PassengerNotFoundException;
import com.dharmaraj.models.Passenger;
import com.dharmaraj.repository.PassengerRepository;
import com.dharmaraj.services.interfaces.PassengerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    @Override
    public Passenger getPassengerById(Long passengerId) {

        return passengerRepository.findById(passengerId).orElseThrow(() -> new PassengerNotFoundException(passengerId));
    }

}
