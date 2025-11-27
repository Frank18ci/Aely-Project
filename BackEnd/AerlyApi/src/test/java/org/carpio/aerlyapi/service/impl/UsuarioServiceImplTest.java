package org.carpio.aerlyapi.service.impl;

import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Rol;
import org.carpio.aerlyapi.model.Usuario;
import org.carpio.aerlyapi.model.dto.UsuarioDto;
import org.carpio.aerlyapi.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private Usuario usuario;
    private Rol rol;

    @BeforeEach
    void setUp() {
        rol = new Rol();
        rol.setId(1L);
        rol.setNombre("USER");

        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setCorreoElectronico("test@example.com");
        usuario.setPassword("password123");
        usuario.setNombres("John");
        usuario.setApellidos("Doe");
        usuario.setFechaNacimiento(new Date());
        usuario.setFechaRegistro(new Date());
        usuario.setEstado(true);
        usuario.setRol(rol);
    }

    @Test
    @DisplayName("loadUserByUsername should return UserDetails when user exists")
    void loadUserByUsername_WhenUserExists_ReturnsUserDetails() {
        when(usuarioRepository.findByCorreoElectronico("test@example.com"))
                .thenReturn(Optional.of(usuario));

        UserDetails result = usuarioService.loadUserByUsername("test@example.com");

        assertNotNull(result);
        assertEquals("test@example.com", result.getUsername());
        assertEquals("password123", result.getPassword());
        assertTrue(result.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("USER")));
    }

    @Test
    @DisplayName("loadUserByUsername should throw exception when user not found")
    void loadUserByUsername_WhenUserNotFound_ThrowsException() {
        when(usuarioRepository.findByCorreoElectronico("nonexistent@example.com"))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () ->
                usuarioService.loadUserByUsername("nonexistent@example.com"));
    }

    @Test
    @DisplayName("loadUserByUsername should use USER as default role when rol nombre is null")
    void loadUserByUsername_WhenRolNombreIsNull_UsesDefaultRole() {
        rol.setNombre(null);
        when(usuarioRepository.findByCorreoElectronico("test@example.com"))
                .thenReturn(Optional.of(usuario));

        UserDetails result = usuarioService.loadUserByUsername("test@example.com");

        assertNotNull(result);
        assertTrue(result.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("USER")));
    }

    @Test
    @DisplayName("getAllUsuarios should return list of UsuarioDto")
    void getAllUsuarios_ReturnsListOfUsuarioDto() {
        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNombres("Jane");
        usuario2.setApellidos("Smith");
        usuario2.setCorreoElectronico("jane@example.com");

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(usuario, usuario2));

        List<UsuarioDto> result = usuarioService.getAllUsuarios();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("getAllUsuarios should return empty list when no users")
    void getAllUsuarios_WhenNoUsers_ReturnsEmptyList() {
        when(usuarioRepository.findAll()).thenReturn(Collections.emptyList());

        List<UsuarioDto> result = usuarioService.getAllUsuarios();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("getUsuarioById should return UsuarioDto when user exists")
    void getUsuarioById_WhenUserExists_ReturnsUsuarioDto() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        UsuarioDto result = usuarioService.getUsuarioById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("John", result.getNombres());
    }

    @Test
    @DisplayName("getUsuarioById should throw ResourceNotFound when user not found")
    void getUsuarioById_WhenUserNotFound_ThrowsException() {
        when(usuarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> usuarioService.getUsuarioById(99L));
    }

    @Test
    @DisplayName("createUsuario should save and return UsuarioDto")
    void createUsuario_SavesAndReturnsUsuarioDto() {
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        UsuarioDto result = usuarioService.createUsuario(usuario);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    @DisplayName("updateUsuario should update and return UsuarioDto when user exists")
    void updateUsuario_WhenUserExists_UpdatesAndReturnsUsuarioDto() {
        Usuario updatedUsuario = new Usuario();
        updatedUsuario.setNombres("Updated John");
        updatedUsuario.setApellidos("Updated Doe");
        updatedUsuario.setCorreoElectronico("updated@example.com");
        updatedUsuario.setPassword("newpassword");
        updatedUsuario.setFechaNacimiento(new Date());
        updatedUsuario.setEstado(true);

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        UsuarioDto result = usuarioService.updateUsuario(1L, updatedUsuario);

        assertNotNull(result);
        verify(usuarioRepository, times(1)).findById(1L);
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    @DisplayName("updateUsuario should throw ResourceNotFound when user not found")
    void updateUsuario_WhenUserNotFound_ThrowsException() {
        when(usuarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () ->
                usuarioService.updateUsuario(99L, usuario));
    }

    @Test
    @DisplayName("deleteUsuario should delete user when user exists")
    void deleteUsuario_WhenUserExists_DeletesUser() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        doNothing().when(usuarioRepository).delete(usuario);

        assertDoesNotThrow(() -> usuarioService.deleteUsuario(1L));

        verify(usuarioRepository, times(1)).findById(1L);
        verify(usuarioRepository, times(1)).delete(usuario);
    }

    @Test
    @DisplayName("deleteUsuario should throw ResourceNotFound when user not found")
    void deleteUsuario_WhenUserNotFound_ThrowsException() {
        when(usuarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> usuarioService.deleteUsuario(99L));
    }

    @Test
    @DisplayName("findByCorreoElectronico should return null (current implementation)")
    void findByCorreoElectronico_ReturnsNull() {
        Usuario result = usuarioService.findByCorreoElectronico("test@example.com");
        assertNull(result);
    }
}
