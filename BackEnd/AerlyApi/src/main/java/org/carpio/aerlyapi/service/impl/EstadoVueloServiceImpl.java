package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.EstadoVuelo;
import org.carpio.aerlyapi.model.dto.EstadoVueloDto;
import org.carpio.aerlyapi.model.utils.EstadoVueloMapper;
import org.carpio.aerlyapi.repository.EstadoVueloRepository;
import org.carpio.aerlyapi.service.EstadoVueloService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoVueloServiceImpl implements EstadoVueloService {
    private final EstadoVueloRepository estadoVueloRepository;

    @Override
    public List<EstadoVueloDto> getAllEstadoVuelos() {
        return EstadoVueloMapper.toDtoList(estadoVueloRepository.findAll());
    }

    @Override
    public EstadoVueloDto getEstadoVueloById(Long id) {
        return EstadoVueloMapper.toDto(estadoVueloRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoVuelo not found with id: " + id)
        ));
    }

    @Override
    public EstadoVueloDto createEstadoVuelo(EstadoVuelo estadoVuelo) {
        return EstadoVueloMapper.toDto(estadoVueloRepository.save(estadoVuelo));
    }

    @Override
    public EstadoVueloDto updateEstadoVuelo(Long id, EstadoVuelo estadoVuelo) {
        EstadoVuelo estadoVueloFound = estadoVueloRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoVuelo not found with id: " + id)
        );
        estadoVueloFound.setEstado(estadoVuelo.getEstado());

        return EstadoVueloMapper.toDto(estadoVueloRepository.save(estadoVueloFound));
    }

    @Override
    public void deleteEstadoVuelo(Long id) {
        EstadoVuelo estadoVueloFound = estadoVueloRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoVuelo not found with id: " + id)
        );
        estadoVueloRepository.delete(estadoVueloFound);
    }
}
