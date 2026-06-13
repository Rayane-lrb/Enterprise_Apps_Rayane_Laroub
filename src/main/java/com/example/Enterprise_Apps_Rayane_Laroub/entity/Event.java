package com.example.Enterprise_Apps_Rayane_Laroub.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name = "time", nullable = false)
    LocalDateTime time;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "organisation", nullable = false)
    String organisation;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    Location location;



    public Event() {}
    public Event(LocalDateTime time, String title, String description, String organisation, String email, Location location) {
        this.time = time;
        this.title = title;
        this.description = description;
        this.organisation = organisation;
        this.email = email;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrgnisation(String orgnisation) {
        this.organisation = orgnisation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(time, event.time) && Objects.equals(title, event.title) && Objects.equals(description, event.description) && Objects.equals(email, event.email) && Objects.equals(organisation, event.organisation) && Objects.equals(location, event.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, title, description, email, organisation, location);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", organisation='" + organisation + '\'' +
                ", location=" + location +
                '}';
    }
}
