package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.entities.Event;

import java.util.List;

public interface EventService {
    public List<Event> getEvents();
    public Event getEventByID();
    public Event addEvent();
    public Event updateEvent();
    public void deleteEvent();
    List<Event> getEventsByVenue();
    List<Event> getEventsByDate();
}
