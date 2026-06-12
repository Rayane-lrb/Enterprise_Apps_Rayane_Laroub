package com.example.Enterprise_Apps_Rayane_Laroub.controller;

import com.example.Enterprise_Apps_Rayane_Laroub.dto.event.EventRequest;
import com.example.Enterprise_Apps_Rayane_Laroub.dto.event.EventResponse;
import com.example.Enterprise_Apps_Rayane_Laroub.entity.Event;
import com.example.Enterprise_Apps_Rayane_Laroub.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    @RequestMapping("/events/{id}")
    public EventResponse findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse save(EventRequest request) {
        return service.save(request);
    }

    @PutMapping("/events/{id}")
    public EventResponse update(EventRequest request, @PathVariable UUID id) {
        return service.update(id, request);
    }

}
