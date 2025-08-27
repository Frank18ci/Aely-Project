package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Pais;
import org.carpio.aerlyapi.model.dto.PaisDto;

import java.util.List;

public interface PaisService {
    List<PaisDto> getAllPais();
    PaisDto getPaisById(Long id);
    PaisDto createPais(Pais pais);
    PaisDto updatePais(Long id, Pais pais);
    void deletePais(Long id);
}
