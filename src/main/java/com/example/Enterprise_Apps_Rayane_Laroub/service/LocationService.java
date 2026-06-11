package com.example.Enterprise_Apps_Rayane_Laroub.service;

import com.example.Enterprise_Apps_Rayane_Laroub.domain.entity.Location;
import com.example.Enterprise_Apps_Rayane_Laroub.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationService {
    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }


    public List<Location> findAll() {
        return repository.findAll();
    }

    public Location findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

}
