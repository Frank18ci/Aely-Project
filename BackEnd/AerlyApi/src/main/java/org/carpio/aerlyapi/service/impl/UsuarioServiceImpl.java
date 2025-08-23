package org.carpio.aerlyapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Usuario;
import org.carpio.aerlyapi.model.dto.UsuarioDto;
import org.carpio.aerlyapi.model.utils.UsuarioMapper;
import org.carpio.aerlyapi.repository.UsuarioRepository;
import org.carpio.aerlyapi.service.UsuarioService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;

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

    @Override
    public Usuario findByCorreoElectronico(String correoElectronico) {
        return null;
    }

    @Override
    public List<UsuarioDto> getAllUsuarios() {
        return UsuarioMapper.toDtoList(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDto getUsuarioById(Long id) {
        return UsuarioMapper.toDto(usuarioRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Usuario no encontrado con id: " + id)));
    }

    @Override
    public UsuarioDto createUsuario(Usuario usuario) {
        return UsuarioMapper.toDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioDto updateUsuario(Long id, Usuario usuario) {
        Usuario usuarioFound = usuarioRepository.findById(id).orElseThrow(() ->
                new ResourceNotFound("Usuario no encontrado con id: " + id));
        usuarioFound.setNombres(usuario.getNombres());
        usuarioFound.setApellidos(usuario.getApellidos());
        usuarioFound.setCorreoElectronico(usuario.getCorreoElectronico());
        usuarioFound.setPassword(usuario.getPassword());
        usuarioFound.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioFound.setPais(usuario.getPais());
        usuarioFound.setIdioma(usuario.getIdioma());
        usuarioFound.setRol(usuario.getRol());
        usuarioFound.setEstado(usuario.isEstado());

        return UsuarioMapper.toDto(usuarioRepository.save(usuarioFound));
    }

    @Override
    public void deleteUsuario(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new ResourceNotFound("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

}
