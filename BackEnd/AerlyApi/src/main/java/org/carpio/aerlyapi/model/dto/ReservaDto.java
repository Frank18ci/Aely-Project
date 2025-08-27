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
public class ReservaDto {
    private Long id;
    private UsuarioDto usuario;
    private Date fechaReserva;
    private EstadoReservaDto estadoReserva;
}
