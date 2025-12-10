package com.tickify.ticket_manager.initializer;

import com.tickify.ticket_manager.entities.*;
import com.tickify.ticket_manager.entities.Enums.TicketType;
import com.tickify.ticket_manager.entities.Enums.UserRole;
import com.tickify.ticket_manager.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {

    private final VenueRepository venueRepository;
    private final EventRepository eventRepository;
    private final EventScheduleRepository eventScheduleRepository;
    private final EventTicketTypeRepository eventTicketTypeRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    @Override
    public void run (ApplicationArguments args){
        System.out.println("Hola");
        loadVenues();
        loadEvents();
        loadEventSchedules();
        loadEventTicketTypes();
        loadUsers();
        loadTickets();
    }

    private void loadVenues() {
        if (venueRepository.count() == 0) {
            List<Venue> venues = List.of(
                    new Venue("Luna Park", "Buenos Aires", "Av. Madero 420", 8500),
                    new Venue("Movistar Arena", "Buenos Aires", "Humboldt 450", 15000),
                    new Venue("Teatro Colón", "Buenos Aires", "Cerrito 628", 2500),
                    new Venue("Estadio Mario Alberto Kempes", "Córdoba", "Av. Cárcano S/N", 57000),
                    new Venue("Orfeo Superdomo", "Córdoba", "Rodríguez del Busto 4086", 14000),
                    new Venue("Estadio Marcelo Bielsa", "Rosario", "Av. Dante Alighieri 7200", 42000),
                    new Venue("Metropolitano Rosario", "Rosario", "Junín 501", 3500),
                    new Venue("Auditorio Nacional del SODRE", "Montevideo", "Andes 1365", 2000)
            );
            venueRepository.saveAll(venues);
        }
    }

    private void loadEvents() {
        if (eventRepository.count() == 0) {

            List<Venue> venues = venueRepository.findAll();
            if (venues.isEmpty()) return; // por si acaso

            List<Event> events = List.of(
                    new Event("Rock Fest 2025", venues.get(0)),
                    new Event("Jazz Night", venues.get(1)),
                    new Event("Stand-Up Internacional", venues.get(2)),
                    new Event("Noche Electrónica", venues.get(3)),
                    new Event("Festival Indie", venues.get(4)),
                    new Event("Ciclo de Piano", venues.get(5)),
                    new Event("Gala Sinfónica", venues.get(6)),
                    new Event("Metal World Tour", venues.get(7))
            );

            eventRepository.saveAll(events);
        }
    }

    private void loadEventSchedules() {
        if (eventScheduleRepository.count() > 0) return;

        List<Event> events = eventRepository.findAll();
        if (events.isEmpty()) return;

        List<EventSchedule> schedules = new ArrayList<>();

        // Evento 0 – Rock Fest 2025 (3 fechas)
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 5, 10, 20, 0), events.get(0)));
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 5, 12, 21, 0), events.get(0)));
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 5, 15, 22, 0), events.get(0)));

        // Evento 1 – Jazz Night (2 fechas)
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 6, 5, 19, 30), events.get(1)));
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 6, 6, 20, 0), events.get(1)));

        // Evento 2 – Stand-Up Internacional (2 fechas)
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 4, 20, 21, 0), events.get(2)));
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 4, 21, 22, 0), events.get(2)));

        // Evento 3 – Noche Electrónica (1 fecha)
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 7, 2, 23, 30), events.get(3)));

        // Evento 4 – Festival Indie (2 fechas)
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 8, 15, 18, 0), events.get(4)));
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 8, 16, 20, 0), events.get(4)));

        // Evento 5 – Ciclo de Piano (1 fecha)
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 9, 10, 19, 0), events.get(5)));

        // Evento 6 – Gala Sinfónica (1 fecha)
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 10, 5, 20, 30), events.get(6)));

        // Evento 7 – Metal World Tour (2 fechas)
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 11, 1, 21, 0), events.get(7)));
        schedules.add(new EventSchedule(LocalDateTime.of(2025, 11, 3, 22, 0), events.get(7)));

        eventScheduleRepository.saveAll(schedules);
    }

    private void loadEventTicketTypes() {
        if (eventTicketTypeRepository.count() > 0) return;

        List<EventSchedule> schedules = eventScheduleRepository.findAll();
        if (schedules.isEmpty()) return;

        List<EventTicketType> ticketTypes = List.of(
                new EventTicketType(TicketType.GENERAL, 15000, 300, schedules.get(0)),
                new EventTicketType(TicketType.VIP, 35000, 120, schedules.get(0)),
                new EventTicketType(TicketType.PREMIUM, 45000, 80, schedules.get(1)),
                new EventTicketType(TicketType.EARLY_BIRD, 12000, 150, schedules.get(1)),

                new EventTicketType(TicketType.GENERAL, 18000, 500, schedules.get(2)),
                new EventTicketType(TicketType.VIP, 40000, 100, schedules.get(2)),
                new EventTicketType(TicketType.PREMIUM, 52000, 60, schedules.get(3)),
                new EventTicketType(TicketType.EARLY_BIRD, 14000, 200, schedules.get(3)),

                new EventTicketType(TicketType.GENERAL, 10000, 600, schedules.get(4)),
                new EventTicketType(TicketType.VIP, 25000, 80, schedules.get(4)),
                new EventTicketType(TicketType.PREMIUM, 30000, 40, schedules.get(5)),
                new EventTicketType(TicketType.EARLY_BIRD, 8000, 250, schedules.get(5)),

                new EventTicketType(TicketType.GENERAL, 22000, 350, schedules.get(6)),
                new EventTicketType(TicketType.VIP, 50000, 150, schedules.get(6)),
                new EventTicketType(TicketType.PREMIUM, 65000, 100, schedules.get(7)),
                new EventTicketType(TicketType.EARLY_BIRD, 18000, 180, schedules.get(7)),

                new EventTicketType(TicketType.GENERAL, 16000, 400, schedules.get(8)),
                new EventTicketType(TicketType.VIP, 30000, 120, schedules.get(8)),
                new EventTicketType(TicketType.PREMIUM, 38000, 70, schedules.get(9)),
                new EventTicketType(TicketType.EARLY_BIRD, 13000, 220, schedules.get(9))
        );

        eventTicketTypeRepository.saveAll(ticketTypes);
    }

    private void loadUsers() {
        if (userRepository.count() > 0) return;

        List<User> users = List.of(
                new User("jack.sparrow@example.com", "jsparrow", "rum123", UserRole.USER),
                new User("frodo.baggins@example.com", "frodo", "ring123", UserRole.USER),
                new User("harry.potter@example.com", "hpotter", "magic123", UserRole.USER),
                new User("tony.stark@example.com", "tstark", "iron123", UserRole.USER),
                new User("bruce.wayne@example.com", "bwayne", "bat123", UserRole.USER),
                new User("neo.matrix@example.com", "neo", "matrix123", UserRole.USER),
                new User("luke.skywalker@example.com", "lskywalker", "force123", UserRole.USER),

                new User("admin.yoda@example.com", "yodaadmin", "forceadmin", UserRole.ADMIN),
                new User("admin.gandalf@example.com", "gandalfadmin", "youShallNotPass", UserRole.ADMIN)
        );

        userRepository.saveAll(users);
    }

    private void loadTickets() {
        if (ticketRepository.count() > 0) return;

        List<EventTicketType> types = eventTicketTypeRepository.findAll();
        List<User> users = userRepository.findAll();

        if(types.isEmpty() || users.isEmpty()) return;

        List<Ticket> tickets = new ArrayList<>();

        // EARLY_BIRD (6 tickets)
        tickets.add(new Ticket(LocalDateTime.of(2024, 1, 10, 14, 0),  types.get(3),  users.get(0)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 1, 12, 16, 20), types.get(7),  users.get(1)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 1, 13, 18, 10), types.get(11), users.get(2)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 1, 15, 10, 45), types.get(15), users.get(3)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 1, 17, 19, 30), types.get(19), users.get(4)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 1, 18, 20, 40), types.get(3),  users.get(5)));

        // GENERAL (16 tickets)
        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 1, 11, 0),   types.get(0),  users.get(6)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 2, 12, 30),  types.get(4),  users.get(0)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 3, 13, 50),  types.get(8),  users.get(1)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 4, 15, 15),  types.get(12), users.get(2)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 5, 16, 40),  types.get(16), users.get(3)));

        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 10, 18, 0),  types.get(0),  users.get(4)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 11, 19, 25), types.get(4),  users.get(5)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 12, 20, 50), types.get(8),  users.get(6)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 13, 22, 10), types.get(12), users.get(0)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 2, 14, 23, 30), types.get(16), users.get(1)));

        tickets.add(new Ticket(LocalDateTime.of(2024, 3, 1, 10, 15),  types.get(0),  users.get(2)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 3, 2, 13, 10),  types.get(4),  users.get(3)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 3, 3, 14, 45),  types.get(8),  users.get(4)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 3, 4, 17, 20),  types.get(12), users.get(5)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 3, 5, 18, 55),  types.get(16), users.get(6)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 3, 6, 20, 5),   types.get(0),  users.get(0)));

        // VIP (6 tickets)
        tickets.add(new Ticket(LocalDateTime.of(2024, 4, 1, 14, 0),   types.get(1),  users.get(1)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 4, 2, 15, 20),  types.get(5),  users.get(2)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 4, 3, 16, 40),  types.get(9),  users.get(3)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 4, 4, 19, 10),  types.get(13), users.get(4)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 4, 5, 20, 35),  types.get(17), users.get(5)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 4, 6, 22, 0),   types.get(1),  users.get(6)));

        // PREMIUM (2 tickets)
        tickets.add(new Ticket(LocalDateTime.of(2024, 5, 1, 11, 45),  types.get(2),  users.get(0)));
        tickets.add(new Ticket(LocalDateTime.of(2024, 5, 2, 13, 30),  types.get(6),  users.get(1)));

        ticketRepository.saveAll(tickets);
    }

}
