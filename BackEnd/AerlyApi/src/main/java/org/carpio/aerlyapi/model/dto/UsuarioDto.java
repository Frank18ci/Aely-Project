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
public class UsuarioDto {
    private Long id;
    private String correoElectronico;
    private String password;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private Date fechaRegistro;
    private boolean estado;
    private PaisDto pais;
    private IdiomaDto idioma;
    private RolDto rol;
}
