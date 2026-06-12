package com.example.Enterprise_Apps_Rayane_Laroub.service;

import com.example.Enterprise_Apps_Rayane_Laroub.dto.event.EventRequest;
import com.example.Enterprise_Apps_Rayane_Laroub.dto.event.EventResponse;
import com.example.Enterprise_Apps_Rayane_Laroub.entity.Event;
import com.example.Enterprise_Apps_Rayane_Laroub.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventResponse createEvent(EventRequest request) {
        Event event = new Event(
                request.time(),
                request.title(),
                request.description(),
                request.organisation(),
                request.email(),
                request.location()
        );
        Event saved = eventRepository.save(event);

        return new EventResponse(
                saved.getId(),
                saved.getTime(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getOrganisation(),
                saved.getEmail(),
                saved.getLocation()
        );
    }

}
