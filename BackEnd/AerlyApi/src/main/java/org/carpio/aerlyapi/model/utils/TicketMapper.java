package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Ticket;
import org.carpio.aerlyapi.model.dto.TicketDto;

import java.util.List;

public class TicketMapper {
    public static TicketDto toDto(Ticket ticket){
        if(ticket == null){
            return null;
        }
        return TicketDto.builder()
                .id(ticket.getId())
                .reserva(ReservaMapper.toDto(ticket.getReserva()))
                .asiento(AsientoMapper.toDto(ticket.getAsiento()))
                .codigoTicket(ticket.getCodigoTicket())
                .fechaEmision(ticket.getFechaEmision())
                .build();
    }
    public static List<TicketDto> toDtoList(List<Ticket> tickets){
        return tickets.stream().map(TicketMapper::toDto).toList();
    }
}
