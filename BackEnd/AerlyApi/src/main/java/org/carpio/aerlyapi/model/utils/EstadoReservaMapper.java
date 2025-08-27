package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.EstadoReserva;
import org.carpio.aerlyapi.model.dto.EstadoReservaDto;

import java.util.List;

public class EstadoReservaMapper {
    public static EstadoReservaDto toDto(EstadoReserva estadoReserva){
        if(estadoReserva == null){
            return null;
        }
        return EstadoReservaDto.builder()
                .id(estadoReserva.getId())
                .estado(estadoReserva.getEstado())
                .build();
    }
    public static List<EstadoReservaDto> toDtoList(List<EstadoReserva> estadoReservas){
        return estadoReservas.stream().map(EstadoReservaMapper::toDto).toList();
    }
}
