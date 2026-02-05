package com.travel.repository;

import com.travel.entity.*;
import com.travel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // ✅ Fetch bookings of logged-in user only
    List<Booking> findByUser(User user);
}
