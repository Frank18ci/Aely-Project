package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.ModeloAvion;
import org.carpio.aerlyapi.model.dto.ModeloAvionDto;
import org.carpio.aerlyapi.model.utils.ModeloAvionMapper;
import org.carpio.aerlyapi.repository.ModeloAvionRepository;
import org.carpio.aerlyapi.service.ModeloAvionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModeloAvionServiceImpl implements ModeloAvionService {
    private final ModeloAvionRepository modeloAvionRepository;

    @Override
    public List<ModeloAvionDto> getAllModelosAvion() {
        return ModeloAvionMapper.toDtoList(modeloAvionRepository.findAll());
    }

    @Override
    public ModeloAvionDto getModeloAvionById(Long id) {
        return ModeloAvionMapper.toDto(modeloAvionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Modelo de Avion no encontrado con id: " + id)
        ));
    }

    @Override
    public ModeloAvionDto createModeloAvion(ModeloAvion modeloAvion) {
        return ModeloAvionMapper.toDto(modeloAvionRepository.save(modeloAvion));
    }

    @Override
    public ModeloAvionDto updateModeloAvion(Long id, ModeloAvion modeloAvion) {
        ModeloAvion modeloAvionFound = modeloAvionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Modelo de Avion no encontrado con id: " + id)
        );
        modeloAvionFound.setNombre(modeloAvion.getNombre());
        modeloAvionFound.setCapacidad(modeloAvion.getCapacidad());
        modeloAvionFound.setPeso(modeloAvion.getPeso());

        return ModeloAvionMapper.toDto(modeloAvionRepository.save(modeloAvionFound));
    }

    @Override
    public void deleteModeloAvion(Long id) {
        ModeloAvion modeloAvionFound = modeloAvionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Modelo de Avion no encontrado con id: " + id)
        );
        modeloAvionRepository.delete(modeloAvionFound);
    }
}
