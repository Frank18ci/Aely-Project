package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Vuelo;
import org.carpio.aerlyapi.model.dto.VueloDto;

import java.util.List;

public class VueloMapper {
    public static VueloDto toDto(Vuelo vuelo){
        if(vuelo == null){
            return null;
        }
        return VueloDto.builder()
                .id(vuelo.getId())
                .codigoVuelo(vuelo.getCodigoVuelo())
                .origen(AeropuertoMapper.toDto(vuelo.getOrigen()))
                .destino(AeropuertoMapper.toDto(vuelo.getDestino()))
                .fechaSalida(vuelo.getFechaSalida())
                .fechaLlegada(vuelo.getFechaLlegada())
                .duracion(vuelo.getDuracion())
                .estado(vuelo.isEstado())
                .estadoVuelo(EstadoVueloMapper.toDto(vuelo.getEstadoVuelo()))
                .avion(AvionMapper.toDto(vuelo.getAvion()))
                .build();

    }
    public static List<VueloDto> toDtoList(List<Vuelo> vuelos){
        return vuelos.stream().map(VueloMapper::toDto).toList();
    }
}
