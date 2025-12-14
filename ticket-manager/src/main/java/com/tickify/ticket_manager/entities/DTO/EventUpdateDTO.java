package com.tickify.ticket_manager.entities.DTO;

import lombok.Data;

@Data
public class EventUpdateDTO {
    private String name;
    private String description;
    private Long venueID;
}
