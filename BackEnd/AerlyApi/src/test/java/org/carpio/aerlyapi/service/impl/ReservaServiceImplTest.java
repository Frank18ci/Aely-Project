package org.carpio.aerlyapi.service.impl;

import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.EstadoReserva;
import org.carpio.aerlyapi.model.Reserva;
import org.carpio.aerlyapi.model.Usuario;
import org.carpio.aerlyapi.model.dto.ReservaDto;
import org.carpio.aerlyapi.repository.ReservaRepository;
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
class ReservaServiceImplTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaServiceImpl reservaService;

    private Reserva reserva;
    private Usuario usuario;
    private EstadoReserva estadoReserva;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombres("John");
        usuario.setApellidos("Doe");
        usuario.setCorreoElectronico("john@example.com");

        estadoReserva = new EstadoReserva();
        estadoReserva.setId(1L);
        estadoReserva.setEstado("CONFIRMADA");

        reserva = new Reserva();
        reserva.setId(1L);
        reserva.setUsuario(usuario);
        reserva.setFechaReserva(new Date());
        reserva.setEstadoReserva(estadoReserva);
    }

    @Test
    @DisplayName("getAllReservas should return list of ReservaDto")
    void getAllReservas_ReturnsListOfReservaDto() {
        Reserva reserva2 = new Reserva();
        reserva2.setId(2L);
        reserva2.setFechaReserva(new Date());

        when(reservaRepository.findAll()).thenReturn(Arrays.asList(reserva, reserva2));

        List<ReservaDto> result = reservaService.getAllReservas();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(reservaRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("getAllReservas should return empty list when no reservations")
    void getAllReservas_WhenNoReservations_ReturnsEmptyList() {
        when(reservaRepository.findAll()).thenReturn(Collections.emptyList());

        List<ReservaDto> result = reservaService.getAllReservas();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("getReservaById should return ReservaDto when reservation exists")
    void getReservaById_WhenReservationExists_ReturnsReservaDto() {
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));

        ReservaDto result = reservaService.getReservaById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    @DisplayName("getReservaById should throw ResourceNotFound when reservation not found")
    void getReservaById_WhenReservationNotFound_ThrowsException() {
        when(reservaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> reservaService.getReservaById(99L));
    }

    @Test
    @DisplayName("createReserva should save and return ReservaDto")
    void createReserva_SavesAndReturnsReservaDto() {
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        ReservaDto result = reservaService.createReserva(reserva);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(reservaRepository, times(1)).save(reserva);
    }

    @Test
    @DisplayName("updateReserva should update and return ReservaDto when reservation exists")
    void updateReserva_WhenReservationExists_UpdatesAndReturnsReservaDto() {
        Reserva updatedReserva = new Reserva();
        updatedReserva.setUsuario(usuario);
        updatedReserva.setFechaReserva(new Date());
        updatedReserva.setEstadoReserva(estadoReserva);

        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        ReservaDto result = reservaService.updateReserva(1L, updatedReserva);

        assertNotNull(result);
        verify(reservaRepository, times(1)).findById(1L);
        verify(reservaRepository, times(1)).save(any(Reserva.class));
    }

    @Test
    @DisplayName("updateReserva should throw ResourceNotFound when reservation not found")
    void updateReserva_WhenReservationNotFound_ThrowsException() {
        when(reservaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () ->
                reservaService.updateReserva(99L, reserva));
    }

    @Test
    @DisplayName("deleteReserva should delete reservation when reservation exists")
    void deleteReserva_WhenReservationExists_DeletesReservation() {
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));
        doNothing().when(reservaRepository).delete(reserva);

        assertDoesNotThrow(() -> reservaService.deleteReserva(1L));

        verify(reservaRepository, times(1)).findById(1L);
        verify(reservaRepository, times(1)).delete(reserva);
    }

    @Test
    @DisplayName("deleteReserva should throw ResourceNotFound when reservation not found")
    void deleteReserva_WhenReservationNotFound_ThrowsException() {
        when(reservaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> reservaService.deleteReserva(99L));
    }
}
