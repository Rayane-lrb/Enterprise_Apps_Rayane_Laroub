package com.example.Enterprise_Apps_Rayane_Laroub.service;

import com.example.Enterprise_Apps_Rayane_Laroub.dto.event.EventRequest;
import com.example.Enterprise_Apps_Rayane_Laroub.dto.event.EventResponse;
import com.example.Enterprise_Apps_Rayane_Laroub.entity.Event;
import com.example.Enterprise_Apps_Rayane_Laroub.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventResponse> findAll() {
        return eventRepository.findAll()
                .stream()
                .map(event -> new EventResponse(
                        event.getId(),
                        event.getTime(),
                        event.getTitle(),
                        event.getDescription(),
                        event.getOrganisation(),
                        event.getEmail(),
                        event.getLocation()
                )).toList();
    }

    public EventResponse findById(UUID id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Event not found"));
        return new EventResponse(
                event.getId(),
                event.getTime(),
                event.getTitle(),
                event.getDescription(),
                event.getOrganisation(),
                event.getEmail(),
                event.getLocation()
        );

    }

    public EventResponse save(EventRequest request) {
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

    public EventResponse update(UUID id, EventRequest request) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        event.setTime(request.time());
        event.setTitle(request.title());
        event.setDescription(request.description());
        event.setOrgnisation(request.organisation());
        event.setEmail(request.email());
        event.setLocation(request.location());

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


    public void deleteEvent(UUID id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found with id: " + id));

        eventRepository.delete(event);
    }

}
