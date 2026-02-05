package com.travel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travel.entity.Booking;
import com.travel.entity.User;
import com.travel.service.BookingService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/my-bookings")
public class my_bookingContoller {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String myBookings(HttpSession session, Model model) {

        User loggedUser = (User) session.getAttribute("loggedUser");

        if (loggedUser == null) {
            return "redirect:/login";
        }

        List<Booking> bookings =
                bookingService.getBookingsByUser(loggedUser.getId());

        model.addAttribute("bookings", bookings);
        return "my-bookings";
    }
}
