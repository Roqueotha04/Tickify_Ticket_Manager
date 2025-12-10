package com.tickify.ticket_manager.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class EventSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "eventSchedule",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<EventTicketType> eventTicketTypes = new ArrayList<>();
}
