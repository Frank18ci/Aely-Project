package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Pago;
import org.carpio.aerlyapi.model.dto.PagoDto;

import java.util.List;

public class PagoMapper {
    public static PagoDto toDto(Pago pago){
        if(pago == null){
            return null;
        }
        return PagoDto.builder()
                .id(pago.getId())
                .reserva(ReservaMapper.toDto(pago.getReserva()))
                .monto(pago.getMonto())
                .moneda(pago.getMoneda())
                .metodoPago(MetodoPagoMapper.toDto(pago.getMetodoPago()))
                .fechaPago(pago.getFechaPago())
                .estadoPago(EstadoPagoMapper.toDto(pago.getEstadoPago()))
                .build();
    }
    public static List<PagoDto> toDtoList(List<Pago> pagos){
        return pagos.stream().map(PagoMapper::toDto).toList();
    }
}
