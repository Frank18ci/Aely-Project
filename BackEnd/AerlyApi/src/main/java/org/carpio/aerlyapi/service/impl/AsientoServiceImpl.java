package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Asiento;
import org.carpio.aerlyapi.model.dto.AsientoDto;
import org.carpio.aerlyapi.model.utils.AsientoMapper;
import org.carpio.aerlyapi.repository.AsientoRepository;
import org.carpio.aerlyapi.service.AsientoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsientoServiceImpl implements AsientoService {
    private final AsientoRepository asientoRepository;

    @Override
    public List<AsientoDto> getAllAsientos() {
        return AsientoMapper.toDtoList(asientoRepository.findAll());
    }

    @Override
    public AsientoDto getAsientoById(Long id) {
        return AsientoMapper.toDto(asientoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Asiento no encontrado con id: " + id)
        ));
    }

    @Override
    public AsientoDto createAsiento(Asiento asiento) {
        return AsientoMapper.toDto(asientoRepository.save(asiento));
    }

    @Override
    public AsientoDto updateAsiento(Long id, Asiento asiento) {
        Asiento asientoFound = asientoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Asiento no encontrado con id: " + id)
        );
        asientoFound.setNumeroAsiento(asiento.getNumeroAsiento());
        asientoFound.setVuelo(asiento.getVuelo());
        asientoFound.setClaseAsiento(asiento.getClaseAsiento());
        asientoFound.setEstadoAsiento(asiento.getEstadoAsiento());

        return AsientoMapper.toDto(asientoRepository.save(asientoFound));
    }

    @Override
    public void deleteAsiento(Long id) {
        Asiento asientoFound = asientoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Asiento no encontrado con id: " + id)
        );
        asientoRepository.delete(asientoFound);
    }
}
