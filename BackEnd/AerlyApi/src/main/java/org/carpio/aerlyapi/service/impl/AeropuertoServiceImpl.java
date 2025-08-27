package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Aeropuerto;
import org.carpio.aerlyapi.model.dto.AeropuertoDto;
import org.carpio.aerlyapi.model.utils.AeropuertoMapper;
import org.carpio.aerlyapi.repository.AeropuertoRepository;
import org.carpio.aerlyapi.service.AeropuertoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AeropuertoServiceImpl implements AeropuertoService {
    private final AeropuertoRepository aeropuertoRepository;

    @Override
    public List<AeropuertoDto> getAllAeropuertos() {
        return AeropuertoMapper.toDtoList(aeropuertoRepository.findAll());
    }

    @Override
    public AeropuertoDto getAeropuertoById(Long id) {
        return AeropuertoMapper.toDto(aeropuertoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Aeropuerto no encontrado con id: " + id)
        ));
    }

    @Override
    public AeropuertoDto createAeropuerto(Aeropuerto aeropuerto) {
        return AeropuertoMapper.toDto(aeropuertoRepository.save(aeropuerto));
    }

    @Override
    public AeropuertoDto updateAeropuerto(Long id, Aeropuerto aeropuerto) {
        Aeropuerto aeropuertoFound = aeropuertoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Aeropuerto no encontrado con id: " + id)
        );
        aeropuertoFound.setNombre(aeropuerto.getNombre());
        aeropuertoFound.setCodigoIata(aeropuerto.getCodigoIata());
        aeropuertoFound.setUbicacion(aeropuerto.getUbicacion());
        aeropuertoFound.setDireccion(aeropuerto.getDireccion());
        aeropuertoFound.setEstado(aeropuerto.isEstado());
        aeropuertoFound.setId_estado(aeropuerto.getId_estado());
        aeropuertoFound.setIdioma(aeropuerto.getIdioma());

        return AeropuertoMapper.toDto(aeropuertoRepository.save(aeropuertoFound));
    }

    @Override
    public void deleteAeropuerto(Long id) {
        Aeropuerto aeropuertoFound = aeropuertoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Aeropuerto no encontrado con id: " + id)
        );
        aeropuertoRepository.delete(aeropuertoFound);

    }
}
