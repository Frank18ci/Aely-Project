package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.ClaseAsiento;
import org.carpio.aerlyapi.model.dto.ClaseAsientoDto;

import java.util.List;

public class ClaseAsientoMapper {
    public static ClaseAsientoDto toDto(ClaseAsiento claseAsiento){
        if(claseAsiento == null){
            return null;
        }
        return ClaseAsientoDto.builder()
                .id(claseAsiento.getId())
                .tipo(claseAsiento.getTipo())
                .build();
    }
    public static List<ClaseAsientoDto> toDtoList(List<ClaseAsiento> claseAsientos){
        return claseAsientos.stream().map(ClaseAsientoMapper::toDto).toList();
    }
}
