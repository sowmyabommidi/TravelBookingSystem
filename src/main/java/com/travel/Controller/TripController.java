package com.travel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;  
@Controller
@RequestMapping("/admin")
public class TripController {

    @GetMapping("/trips")
    public String showTrips(Model model) {
        return "trips";
    }
}
