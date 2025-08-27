package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.ClaseAsiento;
import org.carpio.aerlyapi.model.dto.ClaseAsientoDto;

import java.util.List;

public interface ClaseAsientoService {
    List<ClaseAsientoDto> getAllClaseAsientos();
    ClaseAsientoDto getClaseAsientoById(Long id);
    ClaseAsientoDto createClaseAsiento(ClaseAsiento claseAsiento);
    ClaseAsientoDto updateClaseAsiento(Long id, ClaseAsiento claseAsiento);
    void deleteClaseAsiento(Long id);
}
