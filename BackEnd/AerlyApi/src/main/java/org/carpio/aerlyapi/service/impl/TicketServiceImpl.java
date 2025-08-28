package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Ticket;
import org.carpio.aerlyapi.model.dto.TicketDto;
import org.carpio.aerlyapi.model.utils.TicketMapper;
import org.carpio.aerlyapi.repository.TicketRepository;
import org.carpio.aerlyapi.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public List<TicketDto> getAllTickets() {
        return TicketMapper.toDtoList(ticketRepository.findAll());
    }

    @Override
    public TicketDto getTicketById(Long id) {
        return TicketMapper.toDto(ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Ticket not found with id: " + id)
        ));
    }

    @Override
    public TicketDto createTicket(Ticket ticket) {
        return TicketMapper.toDto(ticketRepository.save(ticket));
    }

    @Override
    public TicketDto updateTicket(Long id, Ticket ticket) {
        Ticket ticketFound = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Ticket not found with id: " + id)
        );
        ticketFound.setReserva(ticket.getReserva());
        ticketFound.setAsiento(ticket.getAsiento());
        ticketFound.setCodigoTicket(ticket.getCodigoTicket());
        ticketFound.setFechaEmision(ticket.getFechaEmision());

        return TicketMapper.toDto(ticketRepository.save(ticketFound));
    }

    @Override
    public void deleteTicket(Long id) {
        Ticket ticketFound = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Ticket not found with id: " + id)
        );
        ticketRepository.delete(ticketFound);
    }
}
