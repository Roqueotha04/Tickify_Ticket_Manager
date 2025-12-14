package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.Exceptions.BusinessException;
import com.tickify.ticket_manager.Exceptions.ResourceNotFoundException;
import com.tickify.ticket_manager.entities.DTO.EventUpdateDTO;
import com.tickify.ticket_manager.entities.Event;
import com.tickify.ticket_manager.entities.Venue;
import com.tickify.ticket_manager.repositories.EventRepository;
import com.tickify.ticket_manager.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    //Only Create EventSchedule if necessary.

    @Autowired
    EventRepository eventRepository;

    @Autowired
    VenueService venueService;

    @Autowired
    TicketRepository ticketRepository;



    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventByID(Long id) {
        Optional<Event> event = eventRepository.findById(id);
       // return event.orElse(null); dont do this.
        return event.orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, EventUpdateDTO eventUpdateDTO) {
        Event event = getEventByID(id);
        event.setName(eventUpdateDTO.getName());
        event.setDescription(eventUpdateDTO.getDescription());
        if(eventUpdateDTO.getVenueID()!=null){
            Venue venue= venueService.getVenueById(eventUpdateDTO.getVenueID());
            event.setVenue(venue);
        }
        return eventRepository.save(event);
    }

    @Override
    public void deactivateEvent(Long id) {
        //First validate the Event exists, then validate if the event has any tickets sold, finally delete.
        Event event = getEventByID(id);
        if(!event.getActive())
            throw new BusinessException("The event is currently inactive");

        if (ticketRepository.hasTicketsForFutureSchedules(event.getId()))
            throw new BusinessException("The event has sold tickets, cannot be deactivated");

        event.setActive(false);
        eventRepository.save(event);
    }

    @Override
    public void activateEvent(Long id){
        Event event = getEventByID(id);
        if (event.getActive()){
            throw new BusinessException("The event is currently active");
        }
        event.setActive(true);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id){
        Event event = getEventByID(id);
        if (ticketRepository.hasTicketsForFutureSchedules(event.getId()))
            throw new BusinessException("The event has sold tickets, cannot be deactivated");

        eventRepository.delete(event);
    }

    @Override
    public List<Event> getEventsByVenue(Long venueId) {
        return eventRepository.findByVenueId(venueId);
    }

    @Override
    public List<Event> getEventsByDate(LocalDateTime dateTime) {
        return eventRepository.findByEventScheduleDate(dateTime);
    }
}
