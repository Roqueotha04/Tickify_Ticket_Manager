package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.Exceptions.BusinessException;
import com.tickify.ticket_manager.Exceptions.ResourceNotFoundException;
import com.tickify.ticket_manager.entities.Event;
import com.tickify.ticket_manager.entities.EventSchedule;
import com.tickify.ticket_manager.repositories.EventScheduleRepository;
import com.tickify.ticket_manager.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventScheduleServiceImpl implements EventScheduleService{

    @Autowired
    EventScheduleRepository eventScheduleRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public EventSchedule addEventSchedule(EventSchedule eventSchedule) {
        if (eventScheduleRepository.existsByEventIdAndDateTime(eventSchedule.getId(), eventSchedule.getDateTime()))
            throw new BusinessException("Cannot add duplicated Schedules");
       return eventScheduleRepository.save(eventSchedule);
    }



    @Override
    public List<EventSchedule> getEventScheduleByEventName(String eventName) {
        return eventScheduleRepository.findByEventName(eventName);
    }

    @Override
    public EventSchedule getEventScheduleById(Long id) {
        Optional<EventSchedule> eventSchedule = eventScheduleRepository.findById(id);
        return eventSchedule.orElseThrow(()-> new ResourceNotFoundException ("Schedule not found"));
    }

    @Override
    public EventSchedule updateDateTime(Long id, LocalDateTime dateTime) {
        EventSchedule eventSchedule= getEventScheduleById(id);
        eventSchedule.setDateTime(dateTime);
        return eventScheduleRepository.save(eventSchedule);
    }

    @Override
    public void deactiveEventSchedule(Long id) {
        EventSchedule eventSchedule = getEventScheduleById(id);
        if (ticketRepository.hasFutureTicketsForOneSchedule(eventSchedule.getId()))
            throw new BusinessException("The schedule has sold tickets, cannot be deactivated");

        eventSchedule.setActive(false);
        eventScheduleRepository.save(eventSchedule);
    }

    @Override
    public void activeEventSchedule(Long id) {
        EventSchedule eventSchedule = getEventScheduleById(id);

        eventSchedule.setActive(true);
        eventScheduleRepository.save(eventSchedule);
    }

    @Override
    public void deleteEventSchedule(Long id) {
        EventSchedule eventSchedule = getEventScheduleById(id);
        if (ticketRepository.hasFutureTicketsForOneSchedule(eventSchedule.getId()))
            throw new BusinessException("The schedule has sold tickets, cannot be deleted");

        eventScheduleRepository.delete(eventSchedule);
    }


}
