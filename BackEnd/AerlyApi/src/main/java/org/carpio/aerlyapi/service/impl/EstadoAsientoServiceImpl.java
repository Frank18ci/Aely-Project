package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.EstadoAsiento;
import org.carpio.aerlyapi.model.dto.EstadoAsientoDto;
import org.carpio.aerlyapi.model.utils.EstadoAsientoMapper;
import org.carpio.aerlyapi.repository.EstadoAsientoRepository;
import org.carpio.aerlyapi.service.EstadoAsientoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoAsientoServiceImpl implements EstadoAsientoService {
    private final EstadoAsientoRepository estadoAsientoRepository;

    @Override
    public List<EstadoAsientoDto> getAllEstadoAsientos() {
        return EstadoAsientoMapper.toDtoList(estadoAsientoRepository.findAll());
    }

    @Override
    public EstadoAsientoDto getEstadoAsientoById(Long id) {
        return EstadoAsientoMapper.toDto(estadoAsientoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Estado de Asiento no encontrado con id: " + id)
        ));
    }

    @Override
    public EstadoAsientoDto createEstadoAsiento(EstadoAsiento estadoAsiento) {
        return EstadoAsientoMapper.toDto(estadoAsientoRepository.save(estadoAsiento));
    }

    @Override
    public EstadoAsientoDto updateEstadoAsiento(Long id, EstadoAsiento estadoAsiento) {
        EstadoAsiento estadoAsientoFound = estadoAsientoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Estado de Asiento no encontrado con id: " + id)
        );
        estadoAsientoFound.setEstado(estadoAsiento.getEstado());

        return EstadoAsientoMapper.toDto(estadoAsientoRepository.save(estadoAsientoFound));
    }

    @Override
    public void deleteEstadoAsiento(Long id) {
        EstadoAsiento estadoAsientoFound = estadoAsientoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Estado de Asiento no encontrado con id: " + id)
        );
        estadoAsientoRepository.delete(estadoAsientoFound);
    }
}
