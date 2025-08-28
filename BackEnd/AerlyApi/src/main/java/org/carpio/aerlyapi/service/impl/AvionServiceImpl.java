package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Avion;
import org.carpio.aerlyapi.model.dto.AvionDto;
import org.carpio.aerlyapi.model.utils.AvionMapper;
import org.carpio.aerlyapi.repository.AvionRepository;
import org.carpio.aerlyapi.service.AvionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvionServiceImpl implements AvionService {
    private final AvionRepository avionRepository;

    @Override
    public List<AvionDto> getAllAviones() {
        return AvionMapper.toDtoList(avionRepository.findAll());
    }

    @Override
    public AvionDto getAvionById(Long id) {
        return AvionMapper.toDto(avionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Avion not found with id: " + id)
        ));
    }

    @Override
    public AvionDto createAvion(Avion avion) {
        return AvionMapper.toDto(avionRepository.save(avion));
    }

    @Override
    public AvionDto updateAvion(Long id, Avion avion) {
        Avion avionFound = avionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Avion not found with id: " + id)
        );
        avionFound.setAerolinea(avion.getAerolinea());
        avionFound.setModeloAvion(avion.getModeloAvion());

        return AvionMapper.toDto(avionRepository.save(avionFound));
    }

    @Override
    public void deleteAvion(Long id) {
        Avion avionFound = avionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Avion not found with id: " + id)
        );
        avionRepository.delete(avionFound);
    }
}
