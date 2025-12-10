package com.tickify.ticket_manager.entities;

import com.tickify.ticket_manager.entities.Enums.TicketType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EventTicketType {


    public EventTicketType(TicketType ticketType, float price, int stock, EventSchedule eventSchedule){
        this.ticketType=ticketType;
        this.price=price;
        this.stock=stock;
        this.eventSchedule=eventSchedule;
    }

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
