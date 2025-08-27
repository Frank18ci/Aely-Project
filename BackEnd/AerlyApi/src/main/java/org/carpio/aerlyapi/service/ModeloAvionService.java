package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.ModeloAvion;
import org.carpio.aerlyapi.model.dto.ModeloAvionDto;

import java.util.List;

public interface ModeloAvionService {
    List<ModeloAvionDto> getAllModelosAvion();
    ModeloAvionDto getModeloAvionById(Long id);
    ModeloAvionDto createModeloAvion(ModeloAvion modeloAvion);
    ModeloAvionDto updateModeloAvion(Long id, ModeloAvion modeloAvion);
    void deleteModeloAvion(Long id);
}
