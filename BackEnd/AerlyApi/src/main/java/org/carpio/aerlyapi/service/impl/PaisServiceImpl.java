package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Pais;
import org.carpio.aerlyapi.model.dto.PaisDto;
import org.carpio.aerlyapi.model.utils.PaisMapper;
import org.carpio.aerlyapi.repository.PaisRepository;
import org.carpio.aerlyapi.service.PaisService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {
    private final PaisRepository paisRepository;

    @Override
    public List<PaisDto> getAllPais() {
        return PaisMapper.toDtoList(paisRepository.findAll());
    }

    @Override
    public PaisDto getPaisById(Long id) {
        return PaisMapper.toDto(paisRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Pais not found with id: " + id)
        ));
    }

    @Override
    public PaisDto createPais(Pais pais) {
        return PaisMapper.toDto(paisRepository.save(pais));
    }

    @Override
    public PaisDto updatePais(Long id, Pais pais) {
        Pais paisFound = paisRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Pais not found with id: " + id)
        );
        paisFound.setNombre(pais.getNombre());
        paisFound.setCodigoTelefonoPais(pais.getCodigoTelefonoPais());
        paisFound.setIcono(pais.getIcono());
        paisFound.setEstado(pais.isEstado());

        return PaisMapper.toDto(paisRepository.save(paisFound));
    }

    @Override
    public void deletePais(Long id) {
        Pais paisFound = paisRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Pais not found with id: " + id)
        );
        paisRepository.delete(paisFound);
    }
}
