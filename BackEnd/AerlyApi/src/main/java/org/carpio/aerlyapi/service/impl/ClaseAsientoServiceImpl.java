package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.ClaseAsiento;
import org.carpio.aerlyapi.model.dto.ClaseAsientoDto;
import org.carpio.aerlyapi.model.utils.ClaseAsientoMapper;
import org.carpio.aerlyapi.repository.ClaseAsientoRepository;
import org.carpio.aerlyapi.service.ClaseAsientoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaseAsientoServiceImpl implements ClaseAsientoService {
    private final ClaseAsientoRepository claseAsientoRepository;

    @Override
    public List<ClaseAsientoDto> getAllClaseAsientos() {
        return ClaseAsientoMapper.toDtoList(claseAsientoRepository.findAll());
    }

    @Override
    public ClaseAsientoDto getClaseAsientoById(Long id) {
        return ClaseAsientoMapper.toDto(claseAsientoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Clase de Asiento no encontrada con id: " + id)
        ));
    }

    @Override
    public ClaseAsientoDto createClaseAsiento(ClaseAsiento claseAsiento) {
        return ClaseAsientoMapper.toDto(claseAsientoRepository.save(claseAsiento));
    }

    @Override
    public ClaseAsientoDto updateClaseAsiento(Long id, ClaseAsiento claseAsiento) {
        ClaseAsiento claseAsientoFound = claseAsientoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Clase de Asiento no encontrada con id: " + id)
        );
        claseAsientoFound.setTipo(claseAsiento.getTipo());

        return ClaseAsientoMapper.toDto(claseAsientoRepository.save(claseAsientoFound));
    }

    @Override
    public void deleteClaseAsiento(Long id) {
        ClaseAsiento claseAsientoFound = claseAsientoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Clase de Asiento no encontrada con id: " + id)
        );
        claseAsientoRepository.delete(claseAsientoFound);
    }
}
