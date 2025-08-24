package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.ModeloAvion;
import org.carpio.aerlyapi.model.dto.ModeloAvionDto;

import java.util.List;

public class ModeloAvionMapper {
    public static ModeloAvionDto toDto(ModeloAvion modeloAvion){
        if(modeloAvion == null){
            return null;
        }
        return ModeloAvionDto.builder()
                .id(modeloAvion.getId())
                .nombre(modeloAvion.getNombre())
                .capacidad(modeloAvion.getCapacidad())
                .peso(modeloAvion.getPeso())
                .build();
    }
    public static List<ModeloAvionDto> toDtoList(List<ModeloAvion> modeloAviones){
        return modeloAviones.stream().map(ModeloAvionMapper::toDto).toList();
    }
}
