package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Rol;
import org.carpio.aerlyapi.model.dto.RolDto;

import java.util.List;

public class RolMapper {
    public static RolDto toDto(Rol rol){
        if(rol == null){
            return null;
        }
        return RolDto.builder()
                .id(rol.getId())
                .nombre(rol.getNombre())
                .build();
    }
    public static List<RolDto> toDtoList(List<Rol> roles){
        return roles.stream().map(RolMapper::toDto).toList();
    }
}
