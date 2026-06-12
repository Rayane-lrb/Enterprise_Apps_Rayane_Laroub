package com.example.Enterprise_Apps_Rayane_Laroub.controller;

import com.example.Enterprise_Apps_Rayane_Laroub.dto.location.LocationResponse;
import com.example.Enterprise_Apps_Rayane_Laroub.entity.Location;
import com.example.Enterprise_Apps_Rayane_Laroub.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class LocationController {

    private final LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    @RequestMapping("/locaties")
    public List<LocationResponse> getLocations() {
        return locationService.findAll();
    }

    @GetMapping
    @RequestMapping("/locaties/{id}")
    public LocationResponse getLocationById(@PathVariable UUID id) {
        return locationService.findById(id);
    }
}
