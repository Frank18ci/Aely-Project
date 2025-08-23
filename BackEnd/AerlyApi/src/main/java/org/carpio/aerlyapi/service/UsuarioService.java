package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Usuario;
import org.carpio.aerlyapi.model.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {
    Usuario findByCorreoElectronico(String correoElectronico);
    List<UsuarioDto> getAllUsuarios();
    UsuarioDto getUsuarioById(Long id);
    UsuarioDto createUsuario(Usuario usuario);
    UsuarioDto updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
}
