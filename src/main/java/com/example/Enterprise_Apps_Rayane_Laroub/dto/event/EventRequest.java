package com.example.Enterprise_Apps_Rayane_Laroub.dto.event;

import com.example.Enterprise_Apps_Rayane_Laroub.entity.Location;

import java.time.LocalDateTime;

public record EventRequest(
        LocalDateTime time,
        String title,
        String description,
        String organisation,
        String email,
        Location location
) {
}
