package com.example.Enterprise_Apps_Rayane_Laroub.dto.event;

import com.example.Enterprise_Apps_Rayane_Laroub.entity.Location;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventResponse(
        UUID id,
        LocalDateTime time,
        String title,
        String description,
        String organisation,
        String email,
        Location location
) {
}
