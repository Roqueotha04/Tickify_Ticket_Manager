package com.tickify.ticket_manager.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date purchaseDate;

    //Unidirectional Relationship
    @ManyToOne()
    @JoinColumn(name = "ticket_type_id")
    private EventTicketType eventTicketType;

    @ManyToOne()
    @JoinColumn (name = "user_id")
    private User user;

}
