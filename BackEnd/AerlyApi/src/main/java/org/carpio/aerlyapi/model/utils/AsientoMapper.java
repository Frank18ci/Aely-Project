package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Asiento;
import org.carpio.aerlyapi.model.dto.AsientoDto;

import java.util.List;

public class AsientoMapper {
    public static AsientoDto toDto(Asiento asiento){
        if(asiento == null){
            return null;
        }
        return AsientoDto.builder()
                .id(asiento.getId())
                .numeroAsiento(asiento.getNumeroAsiento())
                .claseAsiento(ClaseAsientoMapper.toDto(asiento.getClaseAsiento()))
                .vuelo(VueloMapper.toDto(asiento.getVuelo()))
                .estadoAsiento(EstadoAsientoMapper.toDto(asiento.getEstadoAsiento()))
                .build();
    }
    public static List<AsientoDto> toDtoList(List<Asiento> asientos){
        return asientos.stream().map(AsientoMapper::toDto).toList();
    }
}
