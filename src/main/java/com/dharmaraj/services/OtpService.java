package com.dharmaraj.services;

public interface OtpService {

    String generate(Long passengerId);

    void validate(Long passengerId, String otp);
}
