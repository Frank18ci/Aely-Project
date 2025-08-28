package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Estado;
import org.carpio.aerlyapi.model.dto.EstadoDto;
import org.carpio.aerlyapi.model.utils.EstadoMapper;
import org.carpio.aerlyapi.repository.EstadoRepository;
import org.carpio.aerlyapi.service.EstadoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoServiceImpl implements EstadoService {
    private final EstadoRepository estadoRepository;

    @Override
    public List<EstadoDto> getAllEstados() {
        return EstadoMapper.toDtoList(estadoRepository.findAll());
    }

    @Override
    public EstadoDto getEstadoById(Long id) {
        return EstadoMapper.toDto(estadoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Estado not found with id: " + id)
        ));
    }

    @Override
    public EstadoDto createEstado(Estado estado) {
        return EstadoMapper.toDto(estadoRepository.save(estado));
    }

    @Override
    public EstadoDto updateEstado(Long id, Estado estado) {
        Estado estadoFound = estadoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Estado not found with id: " + id)
        );
        estadoFound.setNombre(estado.getNombre());

        return EstadoMapper.toDto(estadoRepository.save(estadoFound));
    }

    @Override
    public void deleteEstado(Long id) {
        Estado estadoFound = estadoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Estado not found with id: " + id)
        );
        estadoRepository.delete(estadoFound);
    }
}
