package org.carpio.aerlyapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDto {
    private Long id;
    private ReservaDto reserva;
    private AsientoDto asiento;
    private String codigoTicket;
    private Date fechaEmision;
}
