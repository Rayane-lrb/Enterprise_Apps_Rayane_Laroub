package com.example.Enterprise_Apps_Rayane_Laroub.repository;

import com.example.Enterprise_Apps_Rayane_Laroub.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
