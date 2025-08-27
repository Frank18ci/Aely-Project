package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Asiento;
import org.carpio.aerlyapi.model.dto.AsientoDto;

import java.util.List;

public interface AsientoService {
    List<AsientoDto> getAllAsientos();
    AsientoDto getAsientoById(Long id);
    AsientoDto createAsiento(Asiento asiento);
    AsientoDto updateAsiento(Long id, Asiento asiento);
    void deleteAsiento(Long id);
}
