package com.tickify.ticket_manager.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Event {


    public Event (String name, String description, Venue venue){
        this.name=name;
        this.active=false;
        this.description= description;
        this.venue=venue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Boolean active;

    @ManyToOne()
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "event",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<EventSchedule> eventSchedules = new ArrayList<>();


}
