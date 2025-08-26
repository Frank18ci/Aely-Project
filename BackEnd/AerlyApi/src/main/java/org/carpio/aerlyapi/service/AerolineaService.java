package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Aerolinea;
import org.carpio.aerlyapi.model.dto.AerolineaDto;

import java.util.List;

public interface AerolineaService {
    List<AerolineaDto> getAllAerolineas();
    AerolineaDto getAerolineaById(Long id);
    AerolineaDto createAerolinea(Aerolinea aerolinea);
    AerolineaDto updateAerolinea(Long id, Aerolinea aerolinea);
    void deleteAerolinea(Long id);
}
