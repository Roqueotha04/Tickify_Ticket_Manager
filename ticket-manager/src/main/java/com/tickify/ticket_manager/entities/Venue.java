package com.tickify.ticket_manager.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Venue {

    public Venue(String name, String city, String address, int capacity) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.capacity = capacity;
    }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String city;
        private String address;
        private int capacity;

        @OneToMany(mappedBy = "venue", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
        private List<Event> eventList= new ArrayList<>();
    }
