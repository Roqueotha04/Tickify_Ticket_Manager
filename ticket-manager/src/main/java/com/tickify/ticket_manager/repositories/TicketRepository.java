package com.tickify.ticket_manager.repositories;

import com.tickify.ticket_manager.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

    @Query("""
    select count(t) > 0
    from Ticket t
    join t.eventTicketType ett
    join ett.eventSchedule es
    where es.event.id = :eventId
    and es.dateTime > CURRENT_TIMESTAMP
    """)
    boolean hasTicketsForFutureSchedules (@Param("eventId") Long eventID);

    @Query("""
    select count(t) > 0
    from Ticket t
    join t.eventTicketType ett
    join ett.eventSchedule es
    where es.id = :eventScheduleId
    and es.dateTime > CURRENT_TIMESTAMP
    """)
    boolean hasFutureTicketsForOneSchedule(@Param("eventScheduleId") Long eventScheduleId);
}
