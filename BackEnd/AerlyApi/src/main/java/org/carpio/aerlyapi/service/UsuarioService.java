package org.carpio.aerlyapi.service;

import org.carpio.aerlyapi.model.Usuario;

public interface UsuarioService {
    Usuario findByCorreoElectronico(String correoElectronico);
}
