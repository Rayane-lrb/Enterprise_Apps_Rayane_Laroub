package com.example.Enterprise_Apps_Rayane_Laroub.repository;

import com.example.Enterprise_Apps_Rayane_Laroub.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {
}
