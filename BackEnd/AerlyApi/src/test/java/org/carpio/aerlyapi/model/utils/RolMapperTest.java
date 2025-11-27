package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.Rol;
import org.carpio.aerlyapi.model.dto.RolDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RolMapperTest {

    @Test
    @DisplayName("toDto should return null when rol is null")
    void toDto_WhenRolIsNull_ReturnsNull() {
        RolDto result = RolMapper.toDto(null);
        assertNull(result);
    }

    @Test
    @DisplayName("toDto should correctly map Rol to RolDto")
    void toDto_WhenValidRol_ReturnsMappedDto() {
        Rol rol = new Rol();
        rol.setId(1L);
        rol.setNombre("ADMIN");

        RolDto result = RolMapper.toDto(rol);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("ADMIN", result.getNombre());
    }

    @Test
    @DisplayName("toDtoList should return empty list when input is empty")
    void toDtoList_WhenEmptyList_ReturnsEmptyList() {
        List<RolDto> result = RolMapper.toDtoList(Collections.emptyList());
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("toDtoList should correctly map list of Rol to list of RolDto")
    void toDtoList_WhenValidList_ReturnsMappedList() {
        Rol rol1 = new Rol();
        rol1.setId(1L);
        rol1.setNombre("ADMIN");

        Rol rol2 = new Rol();
        rol2.setId(2L);
        rol2.setNombre("USER");

        List<RolDto> result = RolMapper.toDtoList(Arrays.asList(rol1, rol2));

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("ADMIN", result.get(0).getNombre());
        assertEquals("USER", result.get(1).getNombre());
    }
}
