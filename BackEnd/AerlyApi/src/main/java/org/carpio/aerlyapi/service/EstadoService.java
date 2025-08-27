package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Estado;
import org.carpio.aerlyapi.model.dto.EstadoDto;

import java.util.List;

public interface EstadoService {
    List<EstadoDto> getAllEstados();
    EstadoDto getEstadoById(Long id);
    EstadoDto createEstado(Estado estado);
    EstadoDto updateEstado(Long id, Estado estado);
    void deleteEstado(Long id);
}
