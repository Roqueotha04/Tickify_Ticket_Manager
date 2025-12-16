package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.entities.EventSchedule;

import java.util.List;

public interface EventScheduleService {
    public EventSchedule addEventSchedule();

    public List<EventSchedule> getEventScheduleByEventName (String eventName);

    public void deleteEventSchedule (EventSchedule eventSchedule);

    public EventSchedule updateEventSchedule (Long id, EventSchedule eventSchedule);
}
