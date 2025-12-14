package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.Exceptions.ResourceNotFoundException;
import com.tickify.ticket_manager.entities.Event;
import com.tickify.ticket_manager.entities.Venue;
import com.tickify.ticket_manager.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueServiceImpl implements VenueService{

    @Autowired
    VenueRepository venueRepository;

    @Override
    public Venue getVenueById(Long id) {
        Optional<Venue> venue = venueRepository.findById(id);
        // return event.orElse(null); dont do this.
        return venue.orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<Venue> getAllVenues() {
        return List.of();
    }

    @Override
    public Venue createVenue(Venue venue) {
        return null;
    }

    @Override
    public Venue updateVenue(Long id, Venue venue) {
        return null;
    }

    @Override
    public void deleteVenue(Long id) {

    }
}
