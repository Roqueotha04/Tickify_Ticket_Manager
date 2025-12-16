package com.tickify.ticket_manager.repositories;

import com.tickify.ticket_manager.entities.Event;
import com.tickify.ticket_manager.entities.EventSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventScheduleRepository extends JpaRepository<EventSchedule, Long> {

    boolean existsByEventIdAndDateTime (Long id, LocalDateTime dateTime);

    List<EventSchedule> findByEventName (String eventName);
}
