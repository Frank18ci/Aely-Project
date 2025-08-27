package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Aeropuerto;
import org.carpio.aerlyapi.model.dto.AeropuertoDto;

import java.util.List;

public interface AeropuertoService {
    List<AeropuertoDto> getAllAeropuertos();
    AeropuertoDto getAeropuertoById(Long id);
    AeropuertoDto createAeropuerto(Aeropuerto aeropuerto);
    AeropuertoDto updateAeropuerto(Long id, Aeropuerto aeropuerto);
    void deleteAeropuerto(Long id);
}
