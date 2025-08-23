package org.carpio.aerlyapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoDto {
    private Long id;
    private String nombre;
    private PaisDto pais;
}
