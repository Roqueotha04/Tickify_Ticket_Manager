package com.tickify.ticket_manager.entities;

import com.tickify.ticket_manager.entities.Enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    public User (String email, String username, String password, UserRole userRole){
        this.email=email;
        this.username=username;
        this.password=password;
        this.userRole=userRole;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Ticket> ticketList=new ArrayList<>();
}
