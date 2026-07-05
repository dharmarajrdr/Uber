package com.dharmaraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.models.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
