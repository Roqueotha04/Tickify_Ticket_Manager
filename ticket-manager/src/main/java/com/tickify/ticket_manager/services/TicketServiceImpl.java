package com.tickify.ticket_manager.services;

import com.tickify.ticket_manager.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{

    //Only create EventTicketType if necessary
    @Autowired
    TicketRepository ticketRepository;
}
