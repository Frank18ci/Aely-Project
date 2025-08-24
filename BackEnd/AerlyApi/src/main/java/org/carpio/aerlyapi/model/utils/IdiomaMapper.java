package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Idioma;
import org.carpio.aerlyapi.model.dto.IdiomaDto;

import java.util.List;

public class IdiomaMapper {
    public static IdiomaDto toDto(Idioma idioma) {
        if(idioma == null) {
            return null;
        }
        return IdiomaDto.builder()
                .id(idioma.getId())
                .nombre(idioma.getNombre())
                .estado(idioma.isEstado())
                .build();
    }
    public static List<IdiomaDto> toDtoList(List<Idioma> idiomas) {
        return idiomas.stream().map(IdiomaMapper::toDto).toList();
    }
}
