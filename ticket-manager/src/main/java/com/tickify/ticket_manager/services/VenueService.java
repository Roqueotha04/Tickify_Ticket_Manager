package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.entities.DTO.VenueUpdateDTO;
import com.tickify.ticket_manager.entities.Venue;

import java.util.List;

public interface VenueService {
    Venue getVenueById(Long id);

    Venue getVenueByName (String name);

    List<Venue> getAllVenues();

    Venue createVenue(Venue venue);

    Venue updateVenue(Long id, VenueUpdateDTO venueDTO);

    void deleteVenue(Long id);
}
