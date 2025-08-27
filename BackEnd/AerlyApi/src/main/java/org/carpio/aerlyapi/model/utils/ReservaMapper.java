package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Reserva;
import org.carpio.aerlyapi.model.dto.ReservaDto;

import java.util.List;

public class ReservaMapper {
    public static ReservaDto toDto(Reserva reserva){
        if(reserva == null){
            return null;
        }
        return ReservaDto.builder()
                .id(reserva.getId())
                .usuario(UsuarioMapper.toDto(reserva.getUsuario()))
                .fechaReserva(reserva.getFechaReserva())
                .estadoReserva(EstadoReservaMapper.toDto(reserva.getEstadoReserva()))
                .build();
    }
    public static List<ReservaDto> toDtoList(List<Reserva> reservas){
        return reservas.stream().map(ReservaMapper::toDto).toList();
    }
}
