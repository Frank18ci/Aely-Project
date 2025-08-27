package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Ticket;
import org.carpio.aerlyapi.model.dto.TicketDto;

import java.util.List;

public interface TicketService {
    List<TicketDto> getAllTickets();
    TicketDto getTicketById(Long id);
    TicketDto createTicket(Ticket ticket);
    TicketDto updateTicket(Long id, Ticket ticket);
    void deleteTicket(Long id);
}
