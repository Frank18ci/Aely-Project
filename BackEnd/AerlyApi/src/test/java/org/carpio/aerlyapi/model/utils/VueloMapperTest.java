package org.carpio.aerlyapi.model.utils;

import org.carpio.aerlyapi.model.*;
import org.carpio.aerlyapi.model.dto.VueloDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VueloMapperTest {

    @Test
    @DisplayName("toDto should return null when vuelo is null")
    void toDto_WhenVueloIsNull_ReturnsNull() {
        VueloDto result = VueloMapper.toDto(null);
        assertNull(result);
    }

    @Test
    @DisplayName("toDto should correctly map Vuelo to VueloDto")
    void toDto_WhenValidVuelo_ReturnsMappedDto() {
        Aeropuerto origen = new Aeropuerto();
        origen.setId(1L);
        origen.setNombre("Aeropuerto Internacional");
        origen.setCodigoIata("ABC");

        Aeropuerto destino = new Aeropuerto();
        destino.setId(2L);
        destino.setNombre("Aeropuerto Nacional");
        destino.setCodigoIata("XYZ");

        Vuelo vuelo = new Vuelo();
        vuelo.setId(1L);
        vuelo.setCodigoVuelo("VL001");
        vuelo.setOrigen(origen);
        vuelo.setDestino(destino);
        vuelo.setFechaSalida(new Date());
        vuelo.setFechaLlegada(new Date());
        vuelo.setDuracion(120);
        vuelo.setEstado(true);

        VueloDto result = VueloMapper.toDto(vuelo);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("VL001", result.getCodigoVuelo());
        assertEquals(120, result.getDuracion());
        assertTrue(result.isEstado());
        assertNotNull(result.getOrigen());
        assertNotNull(result.getDestino());
        assertEquals("ABC", result.getOrigen().getCodigoIata());
        assertEquals("XYZ", result.getDestino().getCodigoIata());
    }

    @Test
    @DisplayName("toDto should handle Vuelo with null relationships")
    void toDto_WhenRelationshipsAreNull_ReturnsDtoWithNullRelationships() {
        Vuelo vuelo = new Vuelo();
        vuelo.setId(1L);
        vuelo.setCodigoVuelo("VL001");
        vuelo.setOrigen(null);
        vuelo.setDestino(null);
        vuelo.setAvion(null);
        vuelo.setEstadoVuelo(null);

        VueloDto result = VueloMapper.toDto(vuelo);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("VL001", result.getCodigoVuelo());
        assertNull(result.getOrigen());
        assertNull(result.getDestino());
        assertNull(result.getAvion());
        assertNull(result.getEstadoVuelo());
    }

    @Test
    @DisplayName("toDtoList should return empty list when input is empty")
    void toDtoList_WhenEmptyList_ReturnsEmptyList() {
        List<VueloDto> result = VueloMapper.toDtoList(Collections.emptyList());
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("toDtoList should correctly map list of Vuelo to list of VueloDto")
    void toDtoList_WhenValidList_ReturnsMappedList() {
        Vuelo vuelo1 = new Vuelo();
        vuelo1.setId(1L);
        vuelo1.setCodigoVuelo("VL001");

        Vuelo vuelo2 = new Vuelo();
        vuelo2.setId(2L);
        vuelo2.setCodigoVuelo("VL002");

        List<VueloDto> result = VueloMapper.toDtoList(Arrays.asList(vuelo1, vuelo2));

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("VL001", result.get(0).getCodigoVuelo());
        assertEquals("VL002", result.get(1).getCodigoVuelo());
    }
}
