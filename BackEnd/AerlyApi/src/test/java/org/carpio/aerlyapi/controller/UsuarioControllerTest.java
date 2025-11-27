package org.carpio.aerlyapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.carpio.aerlyapi.model.Rol;
import org.carpio.aerlyapi.model.Usuario;
import org.carpio.aerlyapi.model.dto.RolDto;
import org.carpio.aerlyapi.model.dto.UsuarioDto;
import org.carpio.aerlyapi.exception.ExceptionHandleController;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    private UsuarioDto usuarioDto;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController)
                .setControllerAdvice(new ExceptionHandleController())
                .build();

        RolDto rolDto = RolDto.builder()
                .id(1L)
                .nombre("USER")
                .build();

        usuarioDto = UsuarioDto.builder()
                .id(1L)
                .correoElectronico("test@example.com")
                .nombres("John")
                .apellidos("Doe")
                .estado(true)
                .rol(rolDto)
                .build();

        Rol rol = new Rol();
        rol.setId(1L);
        rol.setNombre("USER");

        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setCorreoElectronico("test@example.com");
        usuario.setPassword("password123");
        usuario.setNombres("John");
        usuario.setApellidos("Doe");
        usuario.setFechaNacimiento(new Date());
        usuario.setEstado(true);
        usuario.setRol(rol);
    }

    @Test
    @DisplayName("GET /usuarios should return list of users")
    void listarUsuarios_ReturnsListOfUsers() throws Exception {
        UsuarioDto usuarioDto2 = UsuarioDto.builder()
                .id(2L)
                .correoElectronico("jane@example.com")
                .nombres("Jane")
                .apellidos("Smith")
                .build();

        when(usuarioService.getAllUsuarios()).thenReturn(Arrays.asList(usuarioDto, usuarioDto2));

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nombres").value("John"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nombres").value("Jane"));

        verify(usuarioService, times(1)).getAllUsuarios();
    }

    @Test
    @DisplayName("GET /usuarios should return empty list when no users")
    void listarUsuarios_WhenNoUsers_ReturnsEmptyList() throws Exception {
        when(usuarioService.getAllUsuarios()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("GET /usuarios/{id} should return user when found")
    void obtenerUsuarioPorId_WhenUserExists_ReturnsUser() throws Exception {
        when(usuarioService.getUsuarioById(1L)).thenReturn(usuarioDto);

        mockMvc.perform(get("/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombres").value("John"))
                .andExpect(jsonPath("$.correoElectronico").value("test@example.com"));

        verify(usuarioService, times(1)).getUsuarioById(1L);
    }

    @Test
    @DisplayName("GET /usuarios/{id} should return 404 when user not found")
    void obtenerUsuarioPorId_WhenUserNotFound_Returns404() throws Exception {
        when(usuarioService.getUsuarioById(99L)).thenThrow(new ResourceNotFound("Usuario no encontrado con id: 99"));

        mockMvc.perform(get("/usuarios/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /usuarios should create user and return 201")
    void crearUsuario_CreatesUserAndReturns201() throws Exception {
        when(usuarioService.createUsuario(any(Usuario.class))).thenReturn(usuarioDto);

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombres").value("John"));

        verify(usuarioService, times(1)).createUsuario(any(Usuario.class));
    }

    @Test
    @DisplayName("PUT /usuarios/{id} should update user and return 200")
    void actualizarUsuario_UpdatesUserAndReturns200() throws Exception {
        when(usuarioService.updateUsuario(eq(1L), any(Usuario.class))).thenReturn(usuarioDto);

        mockMvc.perform(put("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombres").value("John"));

        verify(usuarioService, times(1)).updateUsuario(eq(1L), any(Usuario.class));
    }

    @Test
    @DisplayName("PUT /usuarios/{id} should return 404 when user not found")
    void actualizarUsuario_WhenUserNotFound_Returns404() throws Exception {
        when(usuarioService.updateUsuario(eq(99L), any(Usuario.class)))
                .thenThrow(new ResourceNotFound("Usuario no encontrado con id: 99"));

        mockMvc.perform(put("/usuarios/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /usuarios/{id} should delete user and return 204")
    void eliminarUsuario_DeletesUserAndReturns204() throws Exception {
        doNothing().when(usuarioService).deleteUsuario(1L);

        mockMvc.perform(delete("/usuarios/1"))
                .andExpect(status().isNoContent());

        verify(usuarioService, times(1)).deleteUsuario(1L);
    }

    @Test
    @DisplayName("DELETE /usuarios/{id} should return 404 when user not found")
    void eliminarUsuario_WhenUserNotFound_Returns404() throws Exception {
        doThrow(new ResourceNotFound("Usuario no encontrado con id: 99"))
                .when(usuarioService).deleteUsuario(99L);

        mockMvc.perform(delete("/usuarios/99"))
                .andExpect(status().isNotFound());
    }
}
