package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Aerolinea;
import org.carpio.aerlyapi.model.dto.AerolineaDto;
import org.carpio.aerlyapi.model.utils.AerolineaMapper;
import org.carpio.aerlyapi.repository.AerolineaRepository;
import org.carpio.aerlyapi.service.AerolineaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AerolineaServiceImpl implements AerolineaService {

    private final AerolineaRepository aerolineaRepository;

    @Override
    public List<AerolineaDto> getAllAerolineas() {
        return AerolineaMapper.toDtoList(aerolineaRepository.findAll());
    }

    @Override
    public AerolineaDto getAerolineaById(Long id) {
        return AerolineaMapper.toDto(aerolineaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Aerolinea no encontrada con id: " + id)
        ));
    }

    @Override
    public AerolineaDto createAerolinea(Aerolinea aerolinea) {
        return AerolineaMapper.toDto(aerolineaRepository.save(aerolinea));
    }

    @Override
    public AerolineaDto updateAerolinea(Long id, Aerolinea aerolinea) {
        Aerolinea aerolineaFound = aerolineaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Aerolinea no encontrada con id: " + id)
        );
        aerolineaFound.setNombre(aerolinea.getNombre());

        return AerolineaMapper.toDto(aerolineaRepository.save(aerolineaFound));
    }

    @Override
    public void deleteAerolinea(Long id) {
        Aerolinea aerolineaFound = aerolineaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Aerolinea no encontrada con id: " + id)
        );
        aerolineaRepository.delete(aerolineaFound);
    }
}
