package org.carpio.aerlyapi.service.impl;

import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.model.Aeropuerto;
import org.carpio.aerlyapi.model.Avion;
import org.carpio.aerlyapi.model.Vuelo;
import org.carpio.aerlyapi.model.dto.VueloDto;
import org.carpio.aerlyapi.repository.VueloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VueloServiceImplTest {

    @Mock
    private VueloRepository vueloRepository;

    @InjectMocks
    private VueloServiceImpl vueloService;

    private Vuelo vuelo;
    private Aeropuerto origen;
    private Aeropuerto destino;

    @BeforeEach
    void setUp() {
        origen = new Aeropuerto();
        origen.setId(1L);
        origen.setNombre("Aeropuerto Origen");
        origen.setCodigoIata("ABC");

        destino = new Aeropuerto();
        destino.setId(2L);
        destino.setNombre("Aeropuerto Destino");
        destino.setCodigoIata("XYZ");

        vuelo = new Vuelo();
        vuelo.setId(1L);
        vuelo.setCodigoVuelo("VL001");
        vuelo.setOrigen(origen);
        vuelo.setDestino(destino);
        vuelo.setFechaSalida(new Date());
        vuelo.setFechaLlegada(new Date());
        vuelo.setDuracion(120);
        vuelo.setEstado(true);
    }

    @Test
    @DisplayName("getAllVuelos should return list of VueloDto")
    void getAllVuelos_ReturnsListOfVueloDto() {
        Vuelo vuelo2 = new Vuelo();
        vuelo2.setId(2L);
        vuelo2.setCodigoVuelo("VL002");

        when(vueloRepository.findAll()).thenReturn(Arrays.asList(vuelo, vuelo2));

        List<VueloDto> result = vueloService.getAllVuelos();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(vueloRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("getAllVuelos should return empty list when no flights")
    void getAllVuelos_WhenNoFlights_ReturnsEmptyList() {
        when(vueloRepository.findAll()).thenReturn(Collections.emptyList());

        List<VueloDto> result = vueloService.getAllVuelos();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("getVueloById should return VueloDto when flight exists")
    void getVueloById_WhenFlightExists_ReturnsVueloDto() {
        when(vueloRepository.findById(1L)).thenReturn(Optional.of(vuelo));

        VueloDto result = vueloService.getVueloById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("VL001", result.getCodigoVuelo());
    }

    @Test
    @DisplayName("getVueloById should throw ResourceNotFound when flight not found")
    void getVueloById_WhenFlightNotFound_ThrowsException() {
        when(vueloRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () -> vueloService.getVueloById(99L));
    }

    @Test
    @DisplayName("createVuelo should save and return VueloDto")
    void createVuelo_SavesAndReturnsVueloDto() {
        when(vueloRepository.save(any(Vuelo.class))).thenReturn(vuelo);

        VueloDto result = vueloService.createVuelo(vuelo);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("VL001", result.getCodigoVuelo());
        verify(vueloRepository, times(1)).save(vuelo);
    }

    @Test
    @DisplayName("updateVuelo should update and return VueloDto when flight exists")
    void updateVuelo_WhenFlightExists_UpdatesAndReturnsVueloDto() {
        Vuelo updatedVuelo = new Vuelo();
        updatedVuelo.setCodigoVuelo("VL001-UPDATED");
        updatedVuelo.setOrigen(origen);
        updatedVuelo.setDestino(destino);
        updatedVuelo.setFechaSalida(new Date());
        updatedVuelo.setFechaLlegada(new Date());
        updatedVuelo.setEstado(true);

        when(vueloRepository.findById(1L)).thenReturn(Optional.of(vuelo));
        when(vueloRepository.save(any(Vuelo.class))).thenReturn(vuelo);

        VueloDto result = vueloService.updateVuelo(1L, updatedVuelo);

        assertNotNull(result);
        verify(vueloRepository, times(1)).findById(1L);
        verify(vueloRepository, times(1)).save(any(Vuelo.class));
    }

    @Test
    @DisplayName("updateVuelo should throw ResourceNotFound when flight not found")
    void updateVuelo_WhenFlightNotFound_ThrowsException() {
        when(vueloRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFound.class, () ->
                vueloService.updateVuelo(99L, vuelo));
    }

    @Test
    @DisplayName("deleteVuelo should delete flight when flight exists")
    void deleteVuelo_WhenFlightExists_DeletesFlight() {
        when(vueloRepository.existsById(1L)).thenReturn(true);
        doNothing().when(vueloRepository).deleteById(1L);

        assertDoesNotThrow(() -> vueloService.deleteVuelo(1L));

        verify(vueloRepository, times(1)).existsById(1L);
        verify(vueloRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("deleteVuelo should throw ResourceNotFound when flight not found")
    void deleteVuelo_WhenFlightNotFound_ThrowsException() {
        when(vueloRepository.existsById(99L)).thenReturn(false);

        assertThrows(ResourceNotFound.class, () -> vueloService.deleteVuelo(99L));
    }
}
