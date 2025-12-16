package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.Exceptions.BusinessException;
import com.tickify.ticket_manager.Exceptions.ResourceNotFoundException;
import com.tickify.ticket_manager.entities.DTO.VenueUpdateDTO;
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
    public Venue getVenueByName(String name) {
        Optional <Venue> venue = venueRepository.findVenueByName(name);
        return venue.orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    @Override
    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    @Override
    public Venue updateVenue(Long id, VenueUpdateDTO venueDTO) {
        Venue venue = getVenueById(id);
        venue.setName(venueDTO.getName());
        venue.setAddress(venueDTO.getAddress());
        venue.setCity(venueDTO.getCity());
        venue.setCapacity(venueDTO.getCapacity());

        return venueRepository.save(venue);
    }

    @Override
    public void deleteVenue(Long id) {
        Venue venue = getVenueById(id);
        if (!venueRepository.hasActiveEvents(venue.getId())) throw new BusinessException("Can´t eliminate a Venue with active events");
        venueRepository.delete(venue);
    }
}
