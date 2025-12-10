package com.tickify.ticket_manager.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Ticket {



    public Ticket (LocalDateTime purchaseDate, EventTicketType eventTicketType, User user){
        this.purchaseDate=purchaseDate;
        this.eventTicketType=eventTicketType;
        this.user=user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime purchaseDate;

    //Unidirectional Relationship
    @ManyToOne()
    @JoinColumn(name = "ticket_type_id")
    private EventTicketType eventTicketType;

    @ManyToOne()
    @JoinColumn (name = "user_id")
    private User user;

}
