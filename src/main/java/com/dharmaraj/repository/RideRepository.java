package com.dharmaraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.models.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {

}
