package org.carpio.aerlyapi.controller;

import lombok.RequiredArgsConstructor;
import org.carpio.aerlyapi.model.EstadoVuelo;
import org.carpio.aerlyapi.service.EstadoVueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados-vuelos")
@RequiredArgsConstructor
public class EstadoVueloController {
    private final EstadoVueloService estadoVueloService;
    @GetMapping
    public ResponseEntity<?> listarEstadosVuelos(){
        return ResponseEntity.status(HttpStatus.OK).body(estadoVueloService.getAllEstadoVuelos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEstadoVueloPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(estadoVueloService.getEstadoVueloById(id));
    }
    @PostMapping
    public ResponseEntity<?> crearEstadoVuelo(@RequestBody EstadoVuelo estadoVuelo){
        return ResponseEntity.status(HttpStatus.CREATED).body(estadoVueloService.createEstadoVuelo(estadoVuelo));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstadoVuelo(@PathVariable Long id, @RequestBody EstadoVuelo estadoVuelo){
        return ResponseEntity.status(HttpStatus.OK).body(estadoVueloService.updateEstadoVuelo(id, estadoVuelo));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstadoVuelo(@PathVariable Long id) {
        estadoVueloService.deleteEstadoVuelo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
