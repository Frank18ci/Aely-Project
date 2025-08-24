package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Pais;
import org.carpio.aerlyapi.model.dto.PaisDto;

import java.util.List;

public class PaisMapper {
    public static PaisDto toDto(Pais pais){
        if(pais == null){
            return null;
        }
        return PaisDto.builder()
                .id(pais.getId())
                .nombre(pais.getNombre())
                .icono(pais.getIcono())
                .codigoTelefonoPais(pais.getCodigoTelefonoPais())
                .estado(pais.isEstado())
                .build();
    }
    public static List<PaisDto> toDtoList(List<Pais> paises){
        return paises.stream().map(PaisMapper::toDto).toList();
    }
}
