package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.EstadoAsiento;
import org.carpio.aerlyapi.model.dto.EstadoAsientoDto;

import java.util.List;

public class EstadoAsientoMapper {
    public static EstadoAsientoDto toDto(EstadoAsiento estadoAsiento){
        if(estadoAsiento == null){
            return null;
        }
        return EstadoAsientoDto.builder()
                .id(estadoAsiento.getId())
                .estado(estadoAsiento.getEstado())
                .build();
    }
    public static List<EstadoAsientoDto> toDtoList(List<EstadoAsiento> estadoAsientos){
        return estadoAsientos.stream().map(EstadoAsientoMapper::toDto).toList();
    }
}
