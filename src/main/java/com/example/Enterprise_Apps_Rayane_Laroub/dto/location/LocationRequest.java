package com.example.Enterprise_Apps_Rayane_Laroub.dto.location;

import jakarta.validation.constraints.NotBlank;

public record LocationRequest(
        String name,
        String address,
        int capacity
) {
}
