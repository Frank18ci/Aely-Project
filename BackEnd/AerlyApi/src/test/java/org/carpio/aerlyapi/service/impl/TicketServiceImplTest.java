package org.carpio.aerlyapi.service.impl;

import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Asiento;
import org.carpio.aerlyapi.model.Reserva;
import org.carpio.aerlyapi.model.Ticket;
import org.carpio.aerlyapi.model.dto.TicketDto;
import org.carpio.aerlyapi.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TicketServiceImplTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketServiceImpl ticketService;

    private Ticket ticket;
    private Reserva reserva;
    private Asiento asiento;

    @BeforeEach
    void setUp() {
        reserva = new Reserva();
        reserva.setId(1L);
        reserva.setFechaReserva(new Date());

        asiento = new Asiento();
        asiento.setId(1L);
        asiento.setNumeroAsiento("A1");

        ticket = new Ticket();
        ticket.setId(1L);
        ticket.setReserva(reserva);
        ticket.setAsiento(asiento);
        ticket.setCodigoTicket("TKT001");
        ticket.setFechaEmision(new Date());
    }

    @Test
    @DisplayName("getAllTickets should return list of TicketDto")
    void getAllTickets_ReturnsListOfTicketDto() {
        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);
        ticket2.setCodigoTicket("TKT002");
        ticket2.setFechaEmision(new Date());

        when(ticketRepository.findAll()).thenReturn(Arrays.asList(ticket, ticket2));

        List<TicketDto> result = ticketService.getAllTickets();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(ticketRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("getAllTickets should return empty list when no tickets")
    void getAllTickets_WhenNoTickets_ReturnsEmptyList() {
        when(ticketRepository.findAll()).thenReturn(Collections.emptyList());

        List<TicketDto> result = ticketService.getAllTickets();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("getTicketById should return TicketDto when ticket exists")
    void getTicketById_WhenTicketExists_ReturnsTicketDto() {
        when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));

        TicketDto result = ticketService.getTicketById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("TKT001", result.getCodigoTicket());
    }

    @Test
    @DisplayName("getTicketById should throw ResourceNotFound when ticket not found")
    void getTicketById_WhenTicketNotFound_ThrowsException() {
        when(ticketRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> ticketService.getTicketById(99L));
    }

    @Test
    @DisplayName("createTicket should save and return TicketDto")
    void createTicket_SavesAndReturnsTicketDto() {
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        TicketDto result = ticketService.createTicket(ticket);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("TKT001", result.getCodigoTicket());
        verify(ticketRepository, times(1)).save(ticket);
    }

    @Test
    @DisplayName("updateTicket should update and return TicketDto when ticket exists")
    void updateTicket_WhenTicketExists_UpdatesAndReturnsTicketDto() {
        Ticket updatedTicket = new Ticket();
        updatedTicket.setReserva(reserva);
        updatedTicket.setAsiento(asiento);
        updatedTicket.setCodigoTicket("TKT001-UPDATED");
        updatedTicket.setFechaEmision(new Date());

        when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        TicketDto result = ticketService.updateTicket(1L, updatedTicket);

        assertNotNull(result);
        verify(ticketRepository, times(1)).findById(1L);
        verify(ticketRepository, times(1)).save(any(Ticket.class));
    }

    @Test
    @DisplayName("updateTicket should throw ResourceNotFound when ticket not found")
    void updateTicket_WhenTicketNotFound_ThrowsException() {
        when(ticketRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () ->
                ticketService.updateTicket(99L, ticket));
    }

    @Test
    @DisplayName("deleteTicket should delete ticket when ticket exists")
    void deleteTicket_WhenTicketExists_DeletesTicket() {
        when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));
        doNothing().when(ticketRepository).delete(ticket);

        assertDoesNotThrow(() -> ticketService.deleteTicket(1L));

        verify(ticketRepository, times(1)).findById(1L);
        verify(ticketRepository, times(1)).delete(ticket);
    }

    @Test
    @DisplayName("deleteTicket should throw ResourceNotFound when ticket not found")
    void deleteTicket_WhenTicketNotFound_ThrowsException() {
        when(ticketRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> ticketService.deleteTicket(99L));
    }
}
