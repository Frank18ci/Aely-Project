package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.EstadoReserva;
import org.carpio.aerlyapi.model.dto.EstadoReservaDto;
import org.carpio.aerlyapi.model.utils.EstadoReservaMapper;
import org.carpio.aerlyapi.repository.EstadoReservaRepository;
import org.carpio.aerlyapi.service.EstadoReservaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoReservaServiceImpl implements EstadoReservaService {
    private final EstadoReservaRepository estadoReservaRepository;

    @Override
    public List<EstadoReservaDto> getAllEstadoReservas() {
        return EstadoReservaMapper.toDtoList(estadoReservaRepository.findAll());
    }

    @Override
    public EstadoReservaDto getEstadoReservaById(Long id) {
        return EstadoReservaMapper.toDto(estadoReservaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoReserva not found with id: " + id)
        ));
    }

    @Override
    public EstadoReservaDto createEstadoReserva(EstadoReserva estadoReserva) {
        return EstadoReservaMapper.toDto(estadoReservaRepository.save(estadoReserva));
    }

    @Override
    public EstadoReservaDto updateEstadoReserva(Long id, EstadoReserva estadoReserva) {
        EstadoReserva estadoReservaFound = estadoReservaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoReserva not found with id: " + id)
        );
        estadoReservaFound.setEstado(estadoReserva.getEstado());

        return EstadoReservaMapper.toDto(estadoReservaRepository.save(estadoReservaFound));
    }

    @Override
    public void deleteEstadoReserva(Long id) {
        EstadoReserva estadoReservaFound = estadoReservaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoReserva not found with id: " + id)
        );
        estadoReservaRepository.delete(estadoReservaFound);
    }
}
