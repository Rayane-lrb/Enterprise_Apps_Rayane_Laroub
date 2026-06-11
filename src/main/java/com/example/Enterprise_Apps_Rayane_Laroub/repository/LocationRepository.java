package com.example.Enterprise_Apps_Rayane_Laroub.repository;

import com.example.Enterprise_Apps_Rayane_Laroub.domain.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {
}
