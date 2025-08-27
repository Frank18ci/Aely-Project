package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Aeropuerto;
import org.carpio.aerlyapi.model.dto.AeropuertoDto;

import java.util.List;

public class AeropuertoMapper {
    public static AeropuertoDto toDto(Aeropuerto aeropuerto){
        if(aeropuerto == null){
            return null;
        }
        return AeropuertoDto.builder()
                .id(aeropuerto.getId())
                .nombre(aeropuerto.getNombre())
                .codigoIata(aeropuerto.getCodigoIata())
                .ubicacion(aeropuerto.getUbicacion())
                .direccion(aeropuerto.getDireccion())
                .idioma(IdiomaMapper.toDto(aeropuerto.getIdioma()))
                .estadoAeropuerto(EstadoMapper.toDto(aeropuerto.getId_estado()))
                .estado(aeropuerto.isEstado())
                .build();
    }
    public static List<AeropuertoDto> toDtoList(List<Aeropuerto> aeropuertos){
        return aeropuertos.stream().map(AeropuertoMapper::toDto).toList();
    }
}
