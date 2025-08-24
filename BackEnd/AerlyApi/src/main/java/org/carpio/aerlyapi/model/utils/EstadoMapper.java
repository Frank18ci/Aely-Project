package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Estado;
import org.carpio.aerlyapi.model.dto.EstadoDto;

import java.util.List;

public class EstadoMapper {
    public static EstadoDto toDto(Estado estado){
        if(estado == null) return null;
        return EstadoDto.builder()
                .id(estado.getId())
                .nombre(estado.getNombre())
                .pais(PaisMapper.toDto(estado.getPais()))
                .build();
    }
    public static List<EstadoDto> toDtoList(List<Estado> estados){
        return estados.stream().map(EstadoMapper::toDto).toList();
    }
}
