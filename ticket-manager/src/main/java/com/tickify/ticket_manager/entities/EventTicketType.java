package com.tickify.ticket_manager.entities;

import com.tickify.ticket_manager.entities.Enums.TicketType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EventTicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    private float price;

    private int stock;

    @ManyToOne()
    @JoinColumn(name = "event_schedule_id")
    private EventSchedule eventSchedule;
}
