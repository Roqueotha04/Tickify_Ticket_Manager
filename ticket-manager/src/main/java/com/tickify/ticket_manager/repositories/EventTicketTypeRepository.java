package com.tickify.ticket_manager.repositories;

import com.tickify.ticket_manager.entities.EventTicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTicketTypeRepository extends JpaRepository<EventTicketType, Long> {
}
