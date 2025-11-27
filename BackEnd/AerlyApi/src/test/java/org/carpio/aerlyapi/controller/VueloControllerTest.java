package org.carpio.aerlyapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.carpio.aerlyapi.model.Aeropuerto;
import org.carpio.aerlyapi.model.Vuelo;
import org.carpio.aerlyapi.model.dto.AeropuertoDto;
import org.carpio.aerlyapi.model.dto.VueloDto;
import org.carpio.aerlyapi.exception.ExceptionHandleController;
import org.carpio.aerlyapi.exception.ResourceNotFound;
import org.carpio.aerlyapi.service.VueloService;
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
class VueloControllerTest {

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private VueloService vueloService;

    @InjectMocks
    private VueloController vueloController;

    private VueloDto vueloDto;
    private Vuelo vuelo;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(vueloController)
                .setControllerAdvice(new ExceptionHandleController())
                .build();

        AeropuertoDto origenDto = AeropuertoDto.builder()
                .id(1L)
                .nombre("Aeropuerto Internacional")
                .codigoIata("ABC")
                .build();

        AeropuertoDto destinoDto = AeropuertoDto.builder()
                .id(2L)
                .nombre("Aeropuerto Nacional")
                .codigoIata("XYZ")
                .build();

        vueloDto = VueloDto.builder()
                .id(1L)
                .codigoVuelo("VL001")
                .origen(origenDto)
                .destino(destinoDto)
                .fechaSalida(new Date())
                .fechaLlegada(new Date())
                .duracion(120)
                .estado(true)
                .build();

        Aeropuerto origen = new Aeropuerto();
        origen.setId(1L);
        origen.setNombre("Aeropuerto Internacional");
        origen.setCodigoIata("ABC");

        Aeropuerto destino = new Aeropuerto();
        destino.setId(2L);
        destino.setNombre("Aeropuerto Nacional");
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
    @DisplayName("GET /vuelos should return list of flights")
    void listarVuelos_ReturnsListOfFlights() throws Exception {
        VueloDto vueloDto2 = VueloDto.builder()
                .id(2L)
                .codigoVuelo("VL002")
                .duracion(180)
                .build();

        when(vueloService.getAllVuelos()).thenReturn(Arrays.asList(vueloDto, vueloDto2));

        mockMvc.perform(get("/vuelos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].codigoVuelo").value("VL001"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].codigoVuelo").value("VL002"));

        verify(vueloService, times(1)).getAllVuelos();
    }

    @Test
    @DisplayName("GET /vuelos should return empty list when no flights")
    void listarVuelos_WhenNoFlights_ReturnsEmptyList() throws Exception {
        when(vueloService.getAllVuelos()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/vuelos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    @DisplayName("GET /vuelos/{id} should return flight when found")
    void obtenerVueloPorId_WhenFlightExists_ReturnsFlight() throws Exception {
        when(vueloService.getVueloById(1L)).thenReturn(vueloDto);

        mockMvc.perform(get("/vuelos/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.codigoVuelo").value("VL001"))
                .andExpect(jsonPath("$.duracion").value(120));

        verify(vueloService, times(1)).getVueloById(1L);
    }

    @Test
    @DisplayName("GET /vuelos/{id} should return 404 when flight not found")
    void obtenerVueloPorId_WhenFlightNotFound_Returns404() throws Exception {
        when(vueloService.getVueloById(99L)).thenThrow(new ResourceNotFound("Vuelo no encontrado con id: 99"));

        mockMvc.perform(get("/vuelos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /vuelos should create flight and return 201")
    void crearVuelo_CreatesFlightAndReturns201() throws Exception {
        when(vueloService.createVuelo(any(Vuelo.class))).thenReturn(vueloDto);

        mockMvc.perform(post("/vuelos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vuelo)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.codigoVuelo").value("VL001"));

        verify(vueloService, times(1)).createVuelo(any(Vuelo.class));
    }

    @Test
    @DisplayName("PUT /vuelos/{id} should update flight and return 200")
    void actualizarVuelo_UpdatesFlightAndReturns200() throws Exception {
        when(vueloService.updateVuelo(eq(1L), any(Vuelo.class))).thenReturn(vueloDto);

        mockMvc.perform(put("/vuelos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vuelo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.codigoVuelo").value("VL001"));

        verify(vueloService, times(1)).updateVuelo(eq(1L), any(Vuelo.class));
    }

    @Test
    @DisplayName("PUT /vuelos/{id} should return 404 when flight not found")
    void actualizarVuelo_WhenFlightNotFound_Returns404() throws Exception {
        when(vueloService.updateVuelo(eq(99L), any(Vuelo.class)))
                .thenThrow(new ResourceNotFound("Vuelo no encontrado con id: 99"));

        mockMvc.perform(put("/vuelos/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vuelo)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /vuelos/{id} should delete flight and return 204")
    void eliminarVuelo_DeletesFlightAndReturns204() throws Exception {
        doNothing().when(vueloService).deleteVuelo(1L);

        mockMvc.perform(delete("/vuelos/1"))
                .andExpect(status().isNoContent());

        verify(vueloService, times(1)).deleteVuelo(1L);
    }

    @Test
    @DisplayName("DELETE /vuelos/{id} should return 404 when flight not found")
    void eliminarVuelo_WhenFlightNotFound_Returns404() throws Exception {
        doThrow(new ResourceNotFound("Vuelo no encontrado con id: 99"))
                .when(vueloService).deleteVuelo(99L);

        mockMvc.perform(delete("/vuelos/99"))
                .andExpect(status().isNotFound());
    }
}
