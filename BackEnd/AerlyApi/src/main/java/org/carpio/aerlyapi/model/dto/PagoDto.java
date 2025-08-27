package org.carpio.aerlyapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagoDto {
    private Long id;
    private ReservaDto reserva;
    private BigDecimal monto;
    private String moneda;
    private MetodoPagoDto metodoPago;
    private Date fechaPago;
    private EstadoPagoDto estadoPago;
}
