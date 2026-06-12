package com.example.Enterprise_Apps_Rayane_Laroub.controller;

import com.example.Enterprise_Apps_Rayane_Laroub.dto.event.EventResponse;
import com.example.Enterprise_Apps_Rayane_Laroub.entity.Event;
import com.example.Enterprise_Apps_Rayane_Laroub.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    @RequestMapping("/events")
    public List<EventResponse> findAll() {
        return service.findAll();
    }

    @PostMapping
    @RequestMapping("/events/{id}")
    public EventResponse findById(@PathVariable int id) {
        return service.findById(id);
    }

}
