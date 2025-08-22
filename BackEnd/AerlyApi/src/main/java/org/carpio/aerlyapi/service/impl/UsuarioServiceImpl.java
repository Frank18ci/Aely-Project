package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Usuario;
import org.carpio.aerlyapi.repository.UsuarioRepository;
import org.carpio.aerlyapi.service.UsuarioService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario findByCorreoElectronico(String correoElectronico) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreoElectronico(username).orElseThrow(() ->
                new ResourceNotFound("Usuario no encontrado con el correo: " + username));
        return User.builder()
                .username(usuario.getCorreoElectronico())
                .password(usuario.getPassword())
                .authorities(
                        usuario.getRol().getNombre() != null ? usuario.getRol().getNombre() : "USER"
                )
                .build();
    }
}
