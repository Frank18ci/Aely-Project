package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Aerolinea;
import org.carpio.aerlyapi.model.dto.AerolineaDto;

import java.util.List;

public class AerolineaMapper {
    public static AerolineaDto toDto(Aerolinea aerolinea){
        if(aerolinea == null){
            return null;
        }
        return AerolineaDto.builder()
                .id(aerolinea.getId())
                .nombre(aerolinea.getNombre())
                .build();
    }
    public static List<AerolineaDto> toDtoList(List<Aerolinea> aerolineas){
        return aerolineas.stream().map(AerolineaMapper::toDto).toList();
    }
}
