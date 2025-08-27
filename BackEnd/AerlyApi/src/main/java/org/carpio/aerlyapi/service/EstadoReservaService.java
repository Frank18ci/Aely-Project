package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.EstadoReserva;
import org.carpio.aerlyapi.model.dto.EstadoReservaDto;

import java.util.List;

public interface EstadoReservaService {
    List<EstadoReservaDto> getAllEstadoReservas();
    EstadoReservaDto getEstadoReservaById(Long id);
    EstadoReservaDto createEstadoReserva(EstadoReserva estadoReserva);
    EstadoReservaDto updateEstadoReserva(Long id, EstadoReserva estadoReserva);
    void deleteEstadoReserva(Long id);
}
