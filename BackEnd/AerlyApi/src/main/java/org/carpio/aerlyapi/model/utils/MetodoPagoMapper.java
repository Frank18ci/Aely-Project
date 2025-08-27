package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.MetodoPago;
import org.carpio.aerlyapi.model.dto.MetodoPagoDto;

import java.util.List;

public class MetodoPagoMapper {
    public static MetodoPagoDto toDto(MetodoPago metodoPago){
        if(metodoPago == null){
            return null;
        }
        return MetodoPagoDto.builder()
                .id(metodoPago.getId())
                .metodo(metodoPago.getMetodo())
                .build();
    }
    public static List<MetodoPagoDto> toDtoList(List<MetodoPago> metodoPagos){
        return metodoPagos.stream().map(MetodoPagoMapper::toDto).toList();
    }
}
