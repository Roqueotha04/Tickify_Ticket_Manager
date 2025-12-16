package com.tickify.ticket_manager.entities.DTO;

import lombok.Data;

@Data
public class VenueUpdateDTO {
    private String name;
    private String address;
    private String city;
    private int capacity;
}
