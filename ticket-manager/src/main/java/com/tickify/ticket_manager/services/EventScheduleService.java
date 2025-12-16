package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.entities.EventSchedule;

import java.time.LocalDateTime;
import java.util.List;

public interface EventScheduleService {
    public EventSchedule addEventSchedule(EventSchedule eventSchedule);

    public List<EventSchedule> getEventScheduleByEventName (String eventName);

    public EventSchedule getEventScheduleById (Long id);

    public EventSchedule updateDateTime(Long id, LocalDateTime dateTime);

    public void deactiveEventSchedule (Long id);

    public void activeEventSchedule (Long id);

    public void deleteEventSchedule (Long id);


}
