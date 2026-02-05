package com.travel.service;

import com.travel.entity.Booking;
import com.travel.entity.User;
import com.travel.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(User user) {
        return bookingRepository.findByUser(user);
    }

    // Get booking by id
    public Booking getBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.orElse(null);
    }

    // Delete booking by id
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    // Existing placeholder method (can remain for compatibility)
    public List<Booking> getBookingsByUser(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
