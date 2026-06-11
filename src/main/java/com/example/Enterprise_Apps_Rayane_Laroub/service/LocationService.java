package com.example.Enterprise_Apps_Rayane_Laroub.service;

import com.example.Enterprise_Apps_Rayane_Laroub.domain.entity.Location;
import com.example.Enterprise_Apps_Rayane_Laroub.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }


    public List<Location> findAll() {
        return repository.findAll();
    }


}
