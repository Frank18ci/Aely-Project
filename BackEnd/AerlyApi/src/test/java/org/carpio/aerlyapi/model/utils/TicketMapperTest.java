package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.*;
import org.carpio.aerlyapi.model.dto.TicketDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketMapperTest {

    @Test
    @DisplayName("toDto should return null when ticket is null")
    void toDto_WhenTicketIsNull_ReturnsNull() {
        TicketDto result = TicketMapper.toDto(null);
        assertNull(result);
    }

    @Test
    @DisplayName("toDto should correctly map Ticket to TicketDto")
    void toDto_WhenValidTicket_ReturnsMappedDto() {
        Reserva reserva = new Reserva();
        reserva.setId(1L);
        reserva.setFechaReserva(new Date());

        Asiento asiento = new Asiento();
        asiento.setId(1L);
        asiento.setNumeroAsiento("A1");

        Date fechaEmision = new Date();

        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setReserva(reserva);
        ticket.setAsiento(asiento);
        ticket.setCodigoTicket("TKT001");
        ticket.setFechaEmision(fechaEmision);

        TicketDto result = TicketMapper.toDto(ticket);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("TKT001", result.getCodigoTicket());
        assertEquals(fechaEmision, result.getFechaEmision());
        assertNotNull(result.getReserva());
        assertNotNull(result.getAsiento());
        assertEquals("A1", result.getAsiento().getNumeroAsiento());
    }

    @Test
    @DisplayName("toDto should handle Ticket with null relationships")
    void toDto_WhenRelationshipsAreNull_ReturnsDtoWithNullRelationships() {
        Date fechaEmision = new Date();

        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setReserva(null);
        ticket.setAsiento(null);
        ticket.setCodigoTicket("TKT001");
        ticket.setFechaEmision(fechaEmision);

        TicketDto result = TicketMapper.toDto(ticket);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("TKT001", result.getCodigoTicket());
        assertNull(result.getReserva());
        assertNull(result.getAsiento());
    }

    @Test
    @DisplayName("toDtoList should return empty list when input is empty")
    void toDtoList_WhenEmptyList_ReturnsEmptyList() {
        List<TicketDto> result = TicketMapper.toDtoList(Collections.emptyList());
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("toDtoList should correctly map list of Ticket to list of TicketDto")
    void toDtoList_WhenValidList_ReturnsMappedList() {
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        ticket1.setCodigoTicket("TKT001");
        ticket1.setFechaEmision(new Date());

        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);
        ticket2.setCodigoTicket("TKT002");
        ticket2.setFechaEmision(new Date());

        List<TicketDto> result = TicketMapper.toDtoList(Arrays.asList(ticket1, ticket2));

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("TKT001", result.get(0).getCodigoTicket());
        assertEquals("TKT002", result.get(1).getCodigoTicket());
    }
}
