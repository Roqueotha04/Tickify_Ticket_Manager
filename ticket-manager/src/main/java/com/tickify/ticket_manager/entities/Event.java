package com.tickify.ticket_manager.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "event",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<EventSchedule> eventSchedules = new ArrayList<>();


}
