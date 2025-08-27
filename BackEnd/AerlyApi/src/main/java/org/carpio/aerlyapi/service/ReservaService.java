package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Reserva;
import org.carpio.aerlyapi.model.dto.ReservaDto;

import java.util.List;

public interface ReservaService {
    List<ReservaDto> getAllReservas();
    ReservaDto getReservaById(Long id);
    ReservaDto createReserva(Reserva reserva);
    ReservaDto updateReserva(Long id, Reserva reserva);
    void deleteReserva(Long id);
}
