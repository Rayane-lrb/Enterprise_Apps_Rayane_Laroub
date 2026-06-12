package com.example.Enterprise_Apps_Rayane_Laroub.service;

import com.example.Enterprise_Apps_Rayane_Laroub.dto.location.LocationRequest;
import com.example.Enterprise_Apps_Rayane_Laroub.dto.location.LocationResponse;
import com.example.Enterprise_Apps_Rayane_Laroub.entity.Location;
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


    public List<LocationResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(location -> new LocationResponse(
                        location.getId(),
                        location.getName(),
                        location.getAddress(),
                        location.getCapacity()
                ))
                .toList();
    }

    public LocationResponse findById(UUID id) {
        return repository.findById(id)
                .map(location -> new LocationResponse(
                        location.getId(),
                        location.getName(),
                        location.getAddress(),
                        location.getCapacity()
                ))
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));
    }

    public LocationResponse CreateLocation(LocationRequest locationRequest) {

        Location location = new Location(
                locationRequest.name(),
                locationRequest.address(),
                locationRequest.capacity()
        );

        Location saved = repository.save(location);

        return new LocationResponse(
                saved.getId(),
                saved.getName(),
                saved.getAddress(),
                saved.getCapacity()
        );
    }

    public LocationResponse UpdateLocation(UUID id, LocationRequest locationRequest) {
        Location location = repository.findById(id).orElseThrow(() -> new RuntimeException("Location not found with id: " + id));

        location.setName(locationRequest.name());
        location.setAddress(locationRequest.address());
        location.setCapacity(locationRequest.capacity());
        Location saved = repository.save(location);

        return new LocationResponse(
                saved.getId(),
                saved.getName(),
                saved.getAddress(),
                saved.getCapacity()
        );
    }

    public void DeleteLocation(UUID id) {
        Location location = repository.findById(id).orElseThrow(() -> new RuntimeException("Location not found with id: " + id));
        repository.delete(location);
    }
}