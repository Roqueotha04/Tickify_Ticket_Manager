package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.entities.Venue;

import java.util.List;

public interface VenueService {
    Venue getVenueById(Long id);

    List<Venue> getAllVenues();

    Venue createVenue(Venue venue);

    Venue updateVenue(Long id, Venue venue);

    void deleteVenue(Long id);
}
