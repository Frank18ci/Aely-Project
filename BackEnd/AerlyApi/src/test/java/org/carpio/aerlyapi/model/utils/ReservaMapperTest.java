package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.*;
import org.carpio.aerlyapi.model.dto.ReservaDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservaMapperTest {

    @Test
    @DisplayName("toDto should return null when reserva is null")
    void toDto_WhenReservaIsNull_ReturnsNull() {
        ReservaDto result = ReservaMapper.toDto(null);
        assertNull(result);
    }

    @Test
    @DisplayName("toDto should correctly map Reserva to ReservaDto")
    void toDto_WhenValidReserva_ReturnsMappedDto() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombres("John");
        usuario.setApellidos("Doe");
        usuario.setCorreoElectronico("john@example.com");

        EstadoReserva estadoReserva = new EstadoReserva();
        estadoReserva.setId(1L);
        estadoReserva.setEstado("CONFIRMADA");

        Date fechaReserva = new Date();

        Reserva reserva = new Reserva();
        reserva.setId(1L);
        reserva.setUsuario(usuario);
        reserva.setFechaReserva(fechaReserva);
        reserva.setEstadoReserva(estadoReserva);

        ReservaDto result = ReservaMapper.toDto(reserva);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(fechaReserva, result.getFechaReserva());
        assertNotNull(result.getUsuario());
        assertEquals("John", result.getUsuario().getNombres());
        assertNotNull(result.getEstadoReserva());
        assertEquals("CONFIRMADA", result.getEstadoReserva().getEstado());
    }

    @Test
    @DisplayName("toDto should handle Reserva with null relationships")
    void toDto_WhenRelationshipsAreNull_ReturnsDtoWithNullRelationships() {
        Date fechaReserva = new Date();

        Reserva reserva = new Reserva();
        reserva.setId(1L);
        reserva.setUsuario(null);
        reserva.setFechaReserva(fechaReserva);
        reserva.setEstadoReserva(null);

        ReservaDto result = ReservaMapper.toDto(reserva);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals(fechaReserva, result.getFechaReserva());
        assertNull(result.getUsuario());
        assertNull(result.getEstadoReserva());
    }

    @Test
    @DisplayName("toDtoList should return empty list when input is empty")
    void toDtoList_WhenEmptyList_ReturnsEmptyList() {
        List<ReservaDto> result = ReservaMapper.toDtoList(Collections.emptyList());
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("toDtoList should correctly map list of Reserva to list of ReservaDto")
    void toDtoList_WhenValidList_ReturnsMappedList() {
        Reserva reserva1 = new Reserva();
        reserva1.setId(1L);
        reserva1.setFechaReserva(new Date());

        Reserva reserva2 = new Reserva();
        reserva2.setId(2L);
        reserva2.setFechaReserva(new Date());

        List<ReservaDto> result = ReservaMapper.toDtoList(Arrays.asList(reserva1, reserva2));

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }
}
