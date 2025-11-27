package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Rol;
import org.carpio.aerlyapi.model.Usuario;
import org.carpio.aerlyapi.model.dto.UsuarioDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioMapperTest {

    @Test
    @DisplayName("toDto should return null when usuario is null")
    void toDto_WhenUsuarioIsNull_ReturnsNull() {
        UsuarioDto result = UsuarioMapper.toDto(null);
        assertNull(result);
    }

    @Test
    @DisplayName("toDto should correctly map Usuario to UsuarioDto")
    void toDto_WhenValidUsuario_ReturnsMappedDto() {
        Rol rol = new Rol();
        rol.setId(1L);
        rol.setNombre("USER");

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setCorreoElectronico("test@example.com");
        usuario.setPassword("password123");
        usuario.setNombres("John");
        usuario.setApellidos("Doe");
        usuario.setFechaNacimiento(new Date());
        usuario.setFechaRegistro(new Date());
        usuario.setEstado(true);
        usuario.setRol(rol);

        UsuarioDto result = UsuarioMapper.toDto(usuario);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("test@example.com", result.getCorreoElectronico());
        assertEquals("John", result.getNombres());
        assertEquals("Doe", result.getApellidos());
        assertNotNull(result.getRol());
        assertEquals("USER", result.getRol().getNombre());
    }

    @Test
    @DisplayName("toDto should handle Usuario with null rol")
    void toDto_WhenRolIsNull_ReturnsDtoWithNullRol() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setCorreoElectronico("test@example.com");
        usuario.setNombres("John");
        usuario.setApellidos("Doe");
        usuario.setRol(null);

        UsuarioDto result = UsuarioMapper.toDto(usuario);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertNull(result.getRol());
    }

    @Test
    @DisplayName("toDtoList should return empty list when input is empty")
    void toDtoList_WhenEmptyList_ReturnsEmptyList() {
        List<UsuarioDto> result = UsuarioMapper.toDtoList(Collections.emptyList());
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("toDtoList should correctly map list of Usuario to list of UsuarioDto")
    void toDtoList_WhenValidList_ReturnsMappedList() {
        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setNombres("John");
        usuario1.setApellidos("Doe");
        usuario1.setCorreoElectronico("john@example.com");

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setNombres("Jane");
        usuario2.setApellidos("Smith");
        usuario2.setCorreoElectronico("jane@example.com");

        List<UsuarioDto> result = UsuarioMapper.toDtoList(Arrays.asList(usuario1, usuario2));

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getNombres());
        assertEquals("Jane", result.get(1).getNombres());
    }
}
