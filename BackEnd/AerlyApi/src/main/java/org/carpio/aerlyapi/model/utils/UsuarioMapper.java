package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Usuario;
import org.carpio.aerlyapi.model.dto.UsuarioDto;

import java.util.List;

public class UsuarioMapper {
    public static UsuarioDto toDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return UsuarioDto.builder()
                .id(usuario.getId())
                .nombres(usuario.getNombres())
                .apellidos(usuario.getApellidos())
                .correoElectronico(usuario.getCorreoElectronico())
                .rol(RolMapper.toDto(usuario.getRol()))
                .build();
    }
    public static List<UsuarioDto> toDtoList(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioMapper::toDto).toList();
    }
}
