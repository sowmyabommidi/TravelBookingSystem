package com.travel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.travel.entity.Booking;
import com.travel.entity.User;
import com.travel.service.BookingService;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Show booking form
    @GetMapping
    public String showBookingForm(
            @RequestParam String destination,
            @RequestParam double price,
            Model model) {

        Booking booking = new Booking();
        booking.setDestination(destination);
        booking.setPrice(price);

        model.addAttribute("booking", booking);
        return "bookings"; // templates/bookings.html
    }

    // Confirm booking
    @PostMapping("/confirm")
    public String confirmBooking(
            @ModelAttribute Booking booking,
            HttpSession session) {

        User loggedUser = (User) session.getAttribute("loggedUser");

        booking.setUser(loggedUser);
        booking.setSeatsBooked(1);

        bookingService.saveBooking(booking);

        // ✅ Store booking for confirmation page
        session.setAttribute("booking", booking);

        return "redirect:/bookings/booking_confirm";
    }

    // Booking confirmation page
    @GetMapping("/booking_confirm")
    public String bookingConfirm(HttpSession session, Model model) {

        // ✅ Fetch booking from session to avoid null error
        Booking booking = (Booking) session.getAttribute("booking");
        model.addAttribute("booking", booking);

        return "booking_confirm"; // templates/booking_confirm.html
    }

    // Show my bookings
    @GetMapping("/my-bookings")
    public String myBookings(HttpSession session, Model model) {

        User loggedUser = (User) session.getAttribute("loggedUser");

        List<Booking> bookings = bookingService.getBookingsByUser(loggedUser);
        model.addAttribute("bookings", bookings);

        return "my-bookings"; // templates/my-bookings.html
    }

    // Cancel booking
    @PostMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable Long id, HttpSession session) {

        User loggedUser = (User) session.getAttribute("loggedUser");
        Booking booking = bookingService.getBookingById(id);

        if (booking != null && booking.getUser().getId().equals(loggedUser.getId())) {
            bookingService.deleteBooking(id);
        }

        return "redirect:/bookings/my-bookings";
    }
}
