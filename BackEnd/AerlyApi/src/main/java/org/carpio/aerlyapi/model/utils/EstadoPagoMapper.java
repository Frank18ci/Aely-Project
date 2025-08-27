package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.EstadoPago;
import org.carpio.aerlyapi.model.dto.EstadoPagoDto;

import java.util.List;

public class EstadoPagoMapper {
    public static EstadoPagoDto toDto(EstadoPago estadoPago){
        if(estadoPago == null){
            return null;
        }
        return EstadoPagoDto.builder()
                .id(estadoPago.getId())
                .estado(estadoPago.getEstado())
                .build();
    }
    public static List<EstadoPagoDto> toDtoList(List<EstadoPago> estadoPagos){
        return estadoPagos.stream().map(EstadoPagoMapper::toDto).toList();
    }
}
