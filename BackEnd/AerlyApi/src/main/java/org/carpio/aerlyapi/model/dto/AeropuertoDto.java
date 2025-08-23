package org.carpio.aerlyapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AeropuertoDto {
    private Long id;
    private String nombre;
    private String codigoIata;
    private String ubicacion;
    private String direccion;
    private boolean estado;
    private EstadoDto estadoAeropuerto;
    private IdiomaDto idioma;

}
