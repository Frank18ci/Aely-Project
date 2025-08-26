package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Idioma;
import org.carpio.aerlyapi.model.dto.IdiomaDto;
import org.carpio.aerlyapi.model.utils.IdiomaMapper;
import org.carpio.aerlyapi.repository.IdiomaRepository;
import org.carpio.aerlyapi.service.IdiomaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdiomaServiceImpl implements IdiomaService {
    private final IdiomaRepository idiomaRepository;


    @Override
    public List<IdiomaDto> getAllIdiomas() {
        return IdiomaMapper.toDtoList(idiomaRepository.findAll());
    }

    @Override
    public IdiomaDto getIdiomaById(Long id) {
        return IdiomaMapper.toDto(idiomaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Idioma no encontrado con id: " + id)
        ));
    }

    @Override
    public IdiomaDto createIdioma(Idioma idioma) {
        return IdiomaMapper.toDto(idiomaRepository.save(idioma));
    }

    @Override
    public IdiomaDto updateIdioma(Long id, Idioma idioma) {
        Idioma idiomaFound = idiomaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Idioma no encontrado con id: " + id)
        );
        idiomaFound.setNombre(idioma.getNombre());
        idiomaFound.setEstado(idioma.isEstado());

        return IdiomaMapper.toDto(idiomaRepository.save(idiomaFound));
    }

    @Override
    public void deleteIdioma(Long id) {
        if(!idiomaRepository.existsById(id)){
            throw new ResourceNotFound("Idioma no encontrado con id: " + id);
        }
        idiomaRepository.deleteById(id);
    }
}
