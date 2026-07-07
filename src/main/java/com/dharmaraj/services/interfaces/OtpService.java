package com.dharmaraj.services.interfaces;

public interface OtpService {

    String generate(Long passengerId);

    void validate(Long passengerId, String otp);
}
