package com.tickify.ticket_manager.entities;

import com.tickify.ticket_manager.entities.Enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    private String password;

    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Ticket> ticketList;
}
