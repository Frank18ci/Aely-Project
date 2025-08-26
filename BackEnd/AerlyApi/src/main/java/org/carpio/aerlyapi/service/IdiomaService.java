package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Idioma;
import org.carpio.aerlyapi.model.dto.IdiomaDto;

import java.util.List;

public interface IdiomaService {
    List<IdiomaDto> getAllIdiomas();
    IdiomaDto getIdiomaById(Long id);
    IdiomaDto createIdioma(Idioma idioma);
    IdiomaDto updateIdioma(Long id, Idioma idioma);
    void deleteIdioma(Long id);
}
