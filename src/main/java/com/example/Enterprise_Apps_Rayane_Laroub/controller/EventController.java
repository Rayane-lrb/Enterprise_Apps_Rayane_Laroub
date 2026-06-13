package com.example.Enterprise_Apps_Rayane_Laroub.controller;

import com.example.Enterprise_Apps_Rayane_Laroub.dto.event.EventRequest;
import com.example.Enterprise_Apps_Rayane_Laroub.service.EventService;
import com.example.Enterprise_Apps_Rayane_Laroub.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class EventController {

    private EventService eventService;
    private LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "index";
    }

    @GetMapping("/events/{id}")
    public String show(@PathVariable UUID id, Model model) {
        model.addAttribute("event", eventService.findById(id));
        return "details";
    }

    @GetMapping("/events/new")
    public String create(Model model) {
        model.addAttribute("locations", locationService.findAll());
        return "create";
    }

    @PostMapping("/events")
    public String store(@ModelAttribute EventRequest event, Model model) {
        model.addAttribute("event", eventService.save(event));
        return "redirect:/";
    }
}
