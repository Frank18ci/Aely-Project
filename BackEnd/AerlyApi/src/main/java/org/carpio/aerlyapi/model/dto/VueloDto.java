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
public class VueloDto {
    private Long id;
    private String codigoVuelo;
    private AeropuertoDto origen;
    private AeropuertoDto destino;
    private Date fechaSalida;
    private Date fechaLlegada;
    private int duracion;
    private boolean estado;
    private EstadoVueloDto estadoVuelo;
    private AvionDto avion;
}
