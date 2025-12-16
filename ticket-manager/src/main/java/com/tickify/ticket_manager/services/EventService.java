package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.entities.DTO.EventUpdateDTO;
import com.tickify.ticket_manager.entities.Event;
import com.tickify.ticket_manager.entities.EventSchedule;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    public List<Event> getEvents();
    public Event getEventByID(Long id);
    public Event addEvent(Event event);
    public Event updateEvent(Long id, EventUpdateDTO eventUpdateDTO);
    public void deactivateEvent(Long id);
    public void activateEvent(Long id);
    public void deleteEvent (Long id);
    List<Event> getEventsByVenueName(String name);
    public Event addEventSchedule (Long eventID, LocalDateTime dateTime);
    List<Event> getEventsByDate(LocalDateTime dateTime);
}
