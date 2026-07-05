package com.dharmaraj.services;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.dharmaraj.config.Constants;
import com.dharmaraj.exceptions.InvalidOtpException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OtpServiceImpl implements OtpService {

    private final StringRedisTemplate redisTemplate;

    private String getRandomOtp(int length) {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append((int) (Math.random() * 10));
        }
        return otp.toString();
    }

    @Override
    public String generate(Long passengerId) {

        String key = Constants.RIDE_OTP_KEY_PREFIX + ":" + String.valueOf(passengerId);

        String otp = redisTemplate.opsForValue().get(key);
        if (otp != null) {
            return otp;
        }

        otp = getRandomOtp(Constants.RIDE_START_OTP_LENGTH);
        redisTemplate.opsForValue().set(key, otp, Constants.RIDE_START_OTP_TTL_SECONDS, TimeUnit.SECONDS);
        return otp;
    }

    @Override
    public void validate(Long passengerId, String otp) {

        if (otp == null) {
            throw new InvalidOtpException("OTP cannot be null.");
        }

        String key = Constants.RIDE_OTP_KEY_PREFIX + ":" + String.valueOf(passengerId);

        String storedOtp = redisTemplate.opsForValue().get(key);
        if (storedOtp == null) {
            throw new InvalidOtpException("OTP has expired or does not exist. Please generate a new OTP.");
        }

        if (!storedOtp.equals(otp)) {
            throw new InvalidOtpException("Invalid OTP. Please try again.");
        }

        redisTemplate.delete(key);
    }

}
