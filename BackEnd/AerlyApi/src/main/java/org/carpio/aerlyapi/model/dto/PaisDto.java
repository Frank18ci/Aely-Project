package org.carpio.aerlyapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaisDto {
    private Long id;
    private String nombre;
    private String icono;
    private String codigoTelefonoPais;
    private boolean estado;
}
