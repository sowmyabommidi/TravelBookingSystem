package com.travel.Controller;

import com.travel.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelController {

    private final TripService tripService;

    public TravelController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public String tripsPage(Model model) {
        model.addAttribute("trips", tripService.getAllTrips());
        return "trips"; // trip.html
    }
}
