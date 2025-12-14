package com.tickify.ticket_manager.repositories;

import com.tickify.ticket_manager.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List <Event> findByVenueId(Long venueId);

    @Query("""
            Select distinct e
            from Event e
            join e.eventSchedules es
            WHERE es.dateTime = :dateTime
            """)
    List <Event> findByEventScheduleDate (@Param("dateTime") LocalDateTime dateTime);
}
