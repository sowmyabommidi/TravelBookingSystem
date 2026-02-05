package com.travel.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.travel.entity.Trip;
import com.travel.repository.TripRepository;

@Service
public class TripService {

    private final TripRepository repo;

    public TripService(TripRepository repo) {
        this.repo = repo;
    }

    public List<Trip> getAllTrips() {
        return repo.findAll();
    }

    public Trip getById(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
