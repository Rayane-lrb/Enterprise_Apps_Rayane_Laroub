package com.example.Enterprise_Apps_Rayane_Laroub.dto.location;

import java.util.UUID;

public record LocationResponse(
        UUID id,
        String name,
        String address,
        int capacity
) {
}
