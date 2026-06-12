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
    String descirption;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "organisation")
    String oragnisation;

    @ManyToOne
    @JoinColumn(name = "location_id")
    Location location;



    public Event() {
    }

    public Event(UUID id, LocalDateTime time, String title, String descirption, String email, String oragnisation, Location location) {
        this.id = id;
        this.time = time;
        this.title = title;
        this.descirption = descirption;
        this.email = email;
        this.oragnisation = oragnisation;
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

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOragnisation() {
        return oragnisation;
    }

    public void setOragnisation(String oragnisation) {
        this.oragnisation = oragnisation;
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
        return Objects.equals(id, event.id) && Objects.equals(time, event.time) && Objects.equals(title, event.title) && Objects.equals(descirption, event.descirption) && Objects.equals(email, event.email) && Objects.equals(oragnisation, event.oragnisation) && Objects.equals(location, event.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, title, descirption, email, oragnisation, location);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", descirption='" + descirption + '\'' +
                ", email='" + email + '\'' +
                ", oragnisation='" + oragnisation + '\'' +
                ", location=" + location +
                '}';
    }
}
