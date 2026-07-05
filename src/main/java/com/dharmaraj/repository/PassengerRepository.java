package com.dharmaraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.models.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
