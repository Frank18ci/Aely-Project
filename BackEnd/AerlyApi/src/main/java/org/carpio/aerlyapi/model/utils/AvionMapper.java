package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Avion;
import org.carpio.aerlyapi.model.dto.AvionDto;

import java.util.List;

public class AvionMapper {
    public static AvionDto toDto(Avion avion){
        if(avion == null){
            return null;
        }
        return AvionDto.builder()
                .id(avion.getId())
                .modeloAvion(ModeloAvionMapper.toDto(avion.getModeloAvion()))
                .aerolinea(AerolineaMapper.toDto(avion.getAerolinea()))
                .build();
    }
    public static List<AvionDto> toDtoList(List<Avion> aviones){
        return aviones.stream().map(AvionMapper::toDto).toList();
    }
}
