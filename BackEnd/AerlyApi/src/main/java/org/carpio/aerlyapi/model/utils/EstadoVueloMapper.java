package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.EstadoVuelo;
import org.carpio.aerlyapi.model.dto.EstadoVueloDto;

import java.util.List;

public class EstadoVueloMapper {
    public static EstadoVueloDto toDto(EstadoVuelo estadoVuelo){
        if(estadoVuelo == null){
            return null;
        }
        return EstadoVueloDto.builder()
                .id(estadoVuelo.getId())
                .estado(estadoVuelo.getEstado())
                .build();
    }
    public static List<EstadoVueloDto> toDtoList(List<EstadoVuelo> estadoVuelos){
        return estadoVuelos.stream().map(EstadoVueloMapper::toDto).toList();
    }
}
