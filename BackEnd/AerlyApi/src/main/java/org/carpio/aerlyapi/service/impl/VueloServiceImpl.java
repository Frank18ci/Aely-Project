package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Vuelo;
import org.carpio.aerlyapi.model.dto.VueloDto;
import org.carpio.aerlyapi.model.utils.VueloMapper;
import org.carpio.aerlyapi.repository.VueloRepository;
import org.carpio.aerlyapi.service.VueloService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VueloServiceImpl implements VueloService {
    private final VueloRepository vueloRepository;

    @Override
    public List<VueloDto> getAllVuelos() {
        return VueloMapper.toDtoList(vueloRepository.findAll());
    }

    @Override
    public VueloDto getVueloById(Long id) {
        return VueloMapper.toDto(vueloRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Vuelo no encontrado con id: " + id)
        ));
    }

    @Override
    public VueloDto createVuelo(Vuelo vuelo) {
        return VueloMapper.toDto(vueloRepository.save(vuelo));
    }

    @Override
    public VueloDto updateVuelo(Long id, Vuelo vuelo) {
        Vuelo vueloFound = vueloRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Vuelo no encontrado con id: " + id)
        );
        vueloFound.setCodigoVuelo(vuelo.getCodigoVuelo());
        vueloFound.setOrigen(vuelo.getOrigen());
        vueloFound.setDestino(vuelo.getDestino());
        vueloFound.setFechaSalida(vuelo.getFechaSalida());
        vueloFound.setFechaLlegada(vuelo.getFechaLlegada());
        vueloFound.setEstado(vuelo.isEstado());
        vueloFound.setAvion(vuelo.getAvion());

        return VueloMapper.toDto(vueloRepository.save(vueloFound));
    }

    @Override
    public void deleteVuelo(Long id) {
        if(!vueloRepository.existsById(id)){
            throw new ResourceNotFound("Vuelo no encontrado con id: " + id);
        }
        vueloRepository.deleteById(id);
    }
}
