package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.EstadoPago;
import org.carpio.aerlyapi.model.dto.EstadoPagoDto;
import org.carpio.aerlyapi.model.utils.EstadoPagoMapper;
import org.carpio.aerlyapi.repository.EstadoPagoRepository;
import org.carpio.aerlyapi.service.EstadoPagoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadoPagoServiceImpl implements EstadoPagoService {
    private final EstadoPagoRepository estadoPagoRepository;

    @Override
    public List<EstadoPagoDto> getAllEstadoPagos() {
        return EstadoPagoMapper.toDtoList(estadoPagoRepository.findAll());
    }

    @Override
    public EstadoPagoDto getEstadoPagoById(Long id) {
        return EstadoPagoMapper.toDto(estadoPagoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoPago not found with id: " + id)
        ));
    }

    @Override
    public EstadoPagoDto createEstadoPago(EstadoPago estadoPago) {
        return EstadoPagoMapper.toDto(estadoPagoRepository.save(estadoPago));
    }

    @Override
    public EstadoPagoDto updateEstadoPago(Long id, EstadoPago estadoPago) {
        EstadoPago estadoPagoFound = estadoPagoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoPago not found with id: " + id)
        );
        estadoPagoFound.setEstado(estadoPago.getEstado());

        return EstadoPagoMapper.toDto(estadoPagoRepository.save(estadoPagoFound));
    }

    @Override
    public void deleteEstadoPago(Long id) {
        EstadoPago estadoPagoFound = estadoPagoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("EstadoPago not found with id: " + id)
        );
        estadoPagoRepository.delete(estadoPagoFound);
    }
}
