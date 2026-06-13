package com.example.Enterprise_Apps_Rayane_Laroub;

import com.example.Enterprise_Apps_Rayane_Laroub.entity.Location;
import com.example.Enterprise_Apps_Rayane_Laroub.entity.Event;
import com.example.Enterprise_Apps_Rayane_Laroub.repository.EventRepository;
import com.example.Enterprise_Apps_Rayane_Laroub.repository.LocationRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private final LocationRepository locationRepository;
    private final EventRepository eventRepository;

    public DataLoader(LocationRepository locationRepository, EventRepository eventRepository) {
        this.locationRepository = locationRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Location location1 = new Location("Gemeenschapszaal Anderlecht", "Leeuwenstraat 3, 1070 Anderlecht", 150);
        Location location2 = new Location("Jaque Brel zaal", "Evenstraat 332, 1070 Anderlecht", 350);
        Location location3 = new Location("Clemence zaal", "Hoofdlaan 52, 1070 Anderlecht", 200);
        locationRepository.saveAll(List.of(location1, location2, location3));

        Event event1 = new Event(LocalDateTime.of(2026, 7, 12, 15, 0), "Trouwfeest", "Gereserveerd voor een trouwfeest" , "Eigen beheer", "contact@ngo-anderlecht.be", location1);
        Event event2 = new Event(LocalDateTime.of(2026, 11, 22, 12, 0), "Geboortefeest", "Gereserveerd voor een Geboortefeest" , "Eigen beheer", "contact@ngo-anderlecht.be", location2);
        Event event3 = new Event(LocalDateTime.of(2026, 12, 1, 14, 0), "Taalcursus Frans", "Gereserveerd voor een taalcursus" , "NGO Anderlecht", "info@ngo-anderlecht.be", location3);
        eventRepository.saveAll(List.of(event1, event2, event3));
    }
}
