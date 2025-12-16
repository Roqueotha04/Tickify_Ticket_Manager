package com.tickify.ticket_manager.repositories;

import com.tickify.ticket_manager.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {

     Optional<Venue> findVenueByName(String name);

    @Query("""
        SELECT COUNT(e) > 0
        FROM Venue v
        JOIN v.eventList e
        WHERE v.id = :venueId
        AND e.active = true
    """)
    boolean hasActiveEvents(@Param("venueId") Long venueId);

}
