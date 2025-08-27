package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Avion;
import org.carpio.aerlyapi.model.dto.AvionDto;

import java.util.List;

public interface AvionService {
    List<AvionDto> getAllAviones();
    AvionDto getAvionById(Long id);
    AvionDto createAvion(Avion avion);
    AvionDto updateAvion(Long id, Avion avion);
    void deleteAvion(Long id);
}
