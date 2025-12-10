package com.tickify.ticket_manager.repositories;

import com.tickify.ticket_manager.entities.EventSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventScheduleRepository extends JpaRepository<EventSchedule, Long> {
}
