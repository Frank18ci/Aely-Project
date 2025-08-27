package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.EstadoVuelo;
import org.carpio.aerlyapi.model.dto.EstadoVueloDto;

import java.util.List;

public interface EstadoVueloService {
    List<EstadoVueloDto> getAllEstadoVuelos();
    EstadoVueloDto getEstadoVueloById(Long id);
    EstadoVueloDto createEstadoVuelo(EstadoVuelo estadoVuelo);
    EstadoVueloDto updateEstadoVuelo(Long id, EstadoVuelo estadoVuelo);
    void deleteEstadoVuelo(Long id);
}
