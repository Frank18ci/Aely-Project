package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Vuelo;
import org.carpio.aerlyapi.model.dto.VueloDto;

import java.util.List;

public interface VueloService {
    List<VueloDto> getAllVuelos();
    VueloDto getVueloById(Long id);
    VueloDto createVuelo(Vuelo vuelo);
    VueloDto updateVuelo(Long id, Vuelo vuelo);
    void deleteVuelo(Long id);
}
