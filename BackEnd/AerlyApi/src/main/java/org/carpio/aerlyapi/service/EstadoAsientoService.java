package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.EstadoAsiento;
import org.carpio.aerlyapi.model.dto.EstadoAsientoDto;

import java.util.List;

public interface EstadoAsientoService {
    List<EstadoAsientoDto> getAllEstadoAsientos();
    EstadoAsientoDto getEstadoAsientoById(Long id);
    EstadoAsientoDto createEstadoAsiento(EstadoAsiento estadoAsiento);
    EstadoAsientoDto updateEstadoAsiento(Long id, EstadoAsiento estadoAsiento);
    void deleteEstadoAsiento(Long id);
}
