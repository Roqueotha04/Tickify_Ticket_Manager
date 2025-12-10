package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.entities.Event;
import com.tickify.ticket_manager.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    //Only Create EventSchedule if necessary.
    //The same for Venue, maybe i´d would be better to create it
    @Autowired
    EventRepository eventRepository;


    @Override
    public List<Event> getEvents() {
        return List.of();
    }

    @Override
    public Event getEventByID() {
        return null;
    }

    @Override
    public Event addEvent() {
        return null;
    }

    @Override
    public Event updateEvent() {
        return null;
    }

    @Override
    public void deleteEvent() {

    }

    @Override
    public List<Event> getEventsByVenue() {
        return List.of();
    }

    @Override
    public List<Event> getEventsByDate() {
        return List.of();
    }
}
