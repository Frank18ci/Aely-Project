package org.carpio.aerlyapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsientoDto {
    private Long id;
    private String numeroAsiento;
    private ClaseAsientoDto claseAsiento;
    private VueloDto vuelo;
    private EstadoAsientoDto estadoAsiento;
}
