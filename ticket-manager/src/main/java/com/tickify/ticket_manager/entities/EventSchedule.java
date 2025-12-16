package com.tickify.ticket_manager.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class EventSchedule {


    public EventSchedule(LocalDateTime dateTime, Event event){
        this.dateTime=dateTime;
        this.event=event;
        this.active=false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private boolean active;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "eventSchedule",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<EventTicketType> eventTicketTypes = new ArrayList<>();
}
