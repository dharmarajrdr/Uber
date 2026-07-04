## Designing a Ride-Sharing Service Like Uber

### Requirements

1. The ride sharing service should allow passengers to request rides and drivers to accept and fulfill those ride requests.
2. Passengers should be able to specify their pickup location, destination, and desired ride type (e.g., regular, premium).
3. Drivers should be able to see available ride requests and choose to accept or decline them.
4. The system should match ride requests with available drivers based on proximity and other factors.
5. The system should calculate the fare for each ride based on distance, time, and ride type.
6. The system should handle payments and process transactions between passengers and drivers.
7. The system should provide real-time tracking of ongoing rides and notify passengers and drivers about ride status updates.
8. The system should handle concurrent requests and ensure data consistency.

---

### Core Entities

1. Ride:
    - id
    - passenger
    - driver
    - status (CREATED, DRIVER_ASSIGNED, PICKED_UP, CANCELLED, COMPLETED)
    - fare
    - created_time
    - scheduled_at
    - pickup_location (LAT, LONG)
    - drop_location (LAT, LONG)
    - tips
    - payment

2. Passenger
    - id
    - name
    - phone
    - upi_id

3. Driver
    - id
    - vehicle 
    - status (OFFLINE, IDLE, ON_DUTY)
    - avg_rating
    - upi_id

4. Vehicle
    - id
    - reg_number
    - type (CAR, BIKE, AUTO, SCOOTY)
    - model (SEDAN, SWIFT, ACTIVA, PULSAR)

5. RideRequest
    - id
    - ride
    - driver
    - response (ACCEPTED, DENIED)
    - created_time

6. Payment
    - id
    - type (UPI, CASH)
    - ride
    